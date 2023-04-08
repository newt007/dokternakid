package com.dokternak.dokternakid.presentation.consultation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentDetailConsultationBinding
import com.dokternak.dokternakid.utils.BundleKeys
import com.dokternak.dokternakid.utils.ConstVal
import com.dokternak.dokternakid.utils.ConstVal.INBOX_CONSULTATION
import com.dokternak.dokternakid.utils.ConstVal.OFFICER_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ConstVal.SENT_CONSULTATION
import com.dokternak.dokternakid.utils.ext.*
import org.koin.android.ext.android.inject

class DetailConsultationFragment : BaseFragment<FragmentDetailConsultationBinding>() {

    private val detailConsultationViewModel: DetailConsultationViewModel by inject()

    private var consultationType: String? = null
    private var id: String? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailConsultationBinding =
        FragmentDetailConsultationBinding.inflate(inflater, container, false)

    override fun initIntent() {
        consultationType = arguments?.getString("type")
        id = arguments?.getString("id")
    }

    override fun initUI() {
        if (consultationType == INBOX_CONSULTATION) {
            binding.layoutComplaint.show()
        }
    }

    override fun initAction() {
        binding.apply {
            toolbarConsultation.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnDelete.click {
                deleteConsultation()
            }
        }
    }

    override fun initProcess() {
        if (consultationType == SENT_CONSULTATION) {
            detailConsultationViewModel.getDetailSentConsultation(id.toString())
        } else {
            detailConsultationViewModel.getDetailSentConsultation(id.toString())
        }
    }

    override fun initObservers() {
        detailConsultationViewModel.detailSentConsultation.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {}
                is ApiResponse.Success -> {
                    val consultData = result.data
                    binding.apply {
                        imgOfficerProfile.setImageUrl(OFFICER_IMAGE_BASE_URL + consultData.photo)
                        tvOfficerName.text = consultData.doctorName
                        tvAnimalType.text =
                            getString(R.string.label_animal_type_is, consultData.animalCategory)
                        tvAnimalName.text =
                            getString(R.string.label_animal_name_is, consultData.animalName)

                        tvComplaintDate.text = consultData.date
                        tvComplaint.text = consultData.complaint
                    }
                }
                is ApiResponse.Empty -> {}
                is ApiResponse.Error -> {}
            }
        }
        detailConsultationViewModel.deleteSentConsultationResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Success -> {
                    showCustomToast(getString(R.string.message_consultation_deleted))
                    sendResult()
                    findNavController().popBackStack()
                }
                is ApiResponse.Error -> {
                    showCustomToast(result.errorMessage)
                }
                else -> {}
            }
        }
    }

    private fun deleteConsultation() {
        if (consultationType == SENT_CONSULTATION) {
            showConfirmDialog(
                title = getString(R.string.title_information),
                message = getString(R.string.message_delete_consultation_confirmation),
                onPositiveClick = {
                    detailConsultationViewModel.deleteSentConsultation(id.toString())
                }
            )
        } else {
            showConfirmDialog(
                title = getString(R.string.title_information),
                message = getString(R.string.message_delete_consultation_confirmation),
                onPositiveClick = {
                    detailConsultationViewModel.deleteInboxConsultation(id.toString())
                }
            )
        }
    }

    private fun sendResult() {
        val bundle = Bundle().apply {
            putString(BundleKeys.BUNDLE_REFRESH, "refresh")
        }
        parentFragmentManager.setFragmentResult(ConstVal.REFRESH_REQUEST_KEY, bundle)
    }

}