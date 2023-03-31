package com.dokternak.dokternakid.presentation.consultation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentAddConsultationBinding
import com.dokternak.dokternakid.domain.officer.model.Officer
import com.dokternak.dokternakid.utils.ext.*
import org.koin.android.ext.android.inject

@Suppress("DEPRECATION")
class AddConsultationFragment : BaseFragment<FragmentAddConsultationBinding>() {

    private var officer: Officer? = null

    private val addConsultationViewModel: AddConsultationViewModel by inject()

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
    }

    override fun initAction() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
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

}