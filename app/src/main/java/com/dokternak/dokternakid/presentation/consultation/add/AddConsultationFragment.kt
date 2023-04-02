package com.dokternak.dokternakid.presentation.consultation.add

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentAddConsultationBinding
import com.dokternak.dokternakid.domain.officer.model.Officer
import com.dokternak.dokternakid.utils.PreferenceManager
import com.dokternak.dokternakid.utils.ext.*
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
class AddConsultationFragment : BaseFragment<FragmentAddConsultationBinding>() {

    private val addConsultationViewModel: AddConsultationViewModel by inject()
    private val prefManager: PreferenceManager by lazy { PreferenceManager(requireContext()) }

    private var officer: Officer? = null
    private var animalType: Int = 0

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentAddConsultationBinding =
        FragmentAddConsultationBinding.inflate(inflater, container, false)

    override fun initIntent() {
        officer = arguments?.getParcelable("officer")
    }

    override fun initUI() {
        binding.edtOfficerName.apply {
            setText(officer?.doctorName.toString())
            disable()
        }
        binding.rbLiveStock.isChecked = true
    }

    override fun initAction() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnSendConsultation.click {
                addNewConsultation()
            }
            spinnerAnimalType.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedPosition = parent?.getItemIdAtPosition(position)?.toInt()
                    selectedPosition?.let { mPosition ->
                        animalType = mPosition + 1
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
    }

    override fun initProcess() {
        addConsultationViewModel.getCategories()
    }

    override fun initObservers() {
        addConsultationViewModel.categoryResults.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {
                    showLoading(true)
                }
                is ApiResponse.Success -> {
                    showLoading(false)
                    val categoryList = mutableListOf<String>()
                    result.data.forEach {
                        categoryList.add(it.categoryArticle)
                    }
                    val categoryAdapter = ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        categoryList
                    ).apply {
                        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    }
                    binding.spinnerAnimalType.adapter = categoryAdapter
                }
                is ApiResponse.Empty -> {
                    showLoading(false)
                }
                is ApiResponse.Error -> {
                    showLoading(false)
                }
            }
        }
        addConsultationViewModel.addNewConsultationResult.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ApiResponse.Loading -> {
                    showLoadingResult(true)
                }
                is ApiResponse.Success -> {
                    showLoadingResult(false)
                    showCustomToast(getString(R.string.message_consultation_sent))
                    findNavController().popBackStack()
                }
                is ApiResponse.Error -> {
                    showLoadingResult(false)
                    showCustomToast(result.errorMessage)
                }
                else -> {}
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun addNewConsultation() {
        val officerName = binding.edtOfficerName.text.toString()
        val animalName = binding.edtAnimalName.text.toString()
        val complaint = binding.edtComplaint.text.toString()
        val selectedRadioButtonId = binding.rbAnimalCategory.checkedRadioButtonId
        val selectedRadioButton = view?.findViewById<RadioButton>(selectedRadioButtonId)
        val selectedAnimal = selectedRadioButton?.text.toString()
        val farmerId = prefManager.farmerId.toString()

        val animalCategory = if (selectedAnimal == "Hewan Ternak") "1" else "2"
        val calendar = Calendar.getInstance()

        val formattedCalendar = SimpleDateFormat("yyyy-MM-dd")
        val date = formattedCalendar.format(calendar.time)
        
        when {
            officerName.isEmpty() -> {
                binding.edtOfficerName.apply { 
                    error = context.getString(R.string.warning_officer_name_must_not_empty)
                    requestFocus()
                }
            }
            animalName.isEmpty() -> {
                binding.edtAnimalName.apply {
                    error = context.getString(R.string.warning_animal_name_must_not_empty)
                    requestFocus()
                }
            }
            complaint.isEmpty() -> {
                binding.edtComplaint.apply {
                    error = context.getString(R.string.warning_complaint_must_not_empty)
                    requestFocus()
                }
            } else -> {
                addConsultationViewModel.addNewConsultation(
                    farmerId,
                    officer?.doctorId.toString(),
                    animalCategory,
                    animalType.toString(),
                    animalName,
                    complaint,
                    "norespon",
                    date
                )
            }
        }
    }

    private fun showLoading(loading: Boolean) {
        if (loading) {
            binding.apply {
                pbCategory.show()
                spinnerAnimalType.hide()
            }
        } else {
            binding.apply {
                pbCategory.gone()
                spinnerAnimalType.show()
            }
        }
    }

    private fun showLoadingResult(loading: Boolean) {
        if (loading) {
            binding.apply {
                pbConsultation.show()
                bgDimmer.show()
            }
        } else {
            binding.apply {
                pbConsultation.gone()
                bgDimmer.gone()
            }
        }
    }

}