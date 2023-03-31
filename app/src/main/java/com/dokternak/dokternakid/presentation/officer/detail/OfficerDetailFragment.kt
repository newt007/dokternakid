package com.dokternak.dokternakid.presentation.officer.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentDetailOfficerBinding
import com.dokternak.dokternakid.utils.ConstVal.OFFICER_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.click
import com.dokternak.dokternakid.utils.ext.setImageUrl
import org.koin.android.ext.android.inject

class OfficerDetailFragment : BaseFragment<FragmentDetailOfficerBinding>() {

    private val officerDetailViewModel: OfficerDetailViewModel by inject()

    private var id: String? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailOfficerBinding =
        FragmentDetailOfficerBinding.inflate(inflater, container, false)

    override fun initIntent() {
        id = arguments?.getString("officer_id")
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            btnBack.click {
                findNavController().popBackStack()
            }
        }
    }

    override fun initProcess() {
        officerDetailViewModel.getOfficerDetail(id.toString())
    }

    override fun initObservers() {
        officerDetailViewModel.getOfficerDetail.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ApiResponse.Loading -> {
                }
                is ApiResponse.Success -> {
                    val officerData = result.data
                    binding.apply {
                        imgProfile.setImageUrl(OFFICER_IMAGE_BASE_URL + officerData.photo)
                        tvOfficerName.text = officerData.doctorName
                        tvOfficerPosition.text = officerData.position
                        tvGender.text = officerData.gender
                        tvEmail.text = officerData.email
                        tvLocation.text = officerData.place
                        tvAddress.text = officerData.address
                        tvPhone.text = officerData.phone
                        tvSchedule.text = officerData.schedule
                    }
                }
                else -> {}
            }
        }
    }

}