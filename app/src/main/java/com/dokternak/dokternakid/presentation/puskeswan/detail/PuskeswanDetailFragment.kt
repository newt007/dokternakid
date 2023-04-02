package com.dokternak.dokternakid.presentation.puskeswan.detail

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentDetailPuskeswanBinding
import com.dokternak.dokternakid.utils.ConstVal.PUSKESWAN_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.click
import com.dokternak.dokternakid.utils.ext.setImageUrl
import com.dokternak.dokternakid.utils.ext.showCustomToast
import org.koin.android.ext.android.inject

class PuskeswanDetailFragment : BaseFragment<FragmentDetailPuskeswanBinding>() {

    private val puskeswanDetailViewModel: PuskeswanDetailViewModel by inject()

    private var puskeswanId: String? = null
    private var puskeswanAddress: String? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailPuskeswanBinding =
        FragmentDetailPuskeswanBinding.inflate(inflater, container, false)

    override fun initIntent() {
        puskeswanId = arguments?.getString("puskeswanId")
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            btnBack.click {
                findNavController().popBackStack()
            }
            btnCheckLocation.click {
                val intentToLocation = Intent(ACTION_VIEW, Uri.parse(puskeswanAddress))
                startActivity(intentToLocation)
            }
        }
    }

    override fun initProcess() {
        puskeswanDetailViewModel.getDetailPuskeswan(puskeswanId.toString())
    }

    override fun initObservers() {
        puskeswanDetailViewModel.detailPuskeswan.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ApiResponse.Loading -> {

                }
                is ApiResponse.Success -> {
                    val puskeswanData = result.data
                    binding.apply {
                        imgPuskeswan.setImageUrl(PUSKESWAN_IMAGE_BASE_URL + puskeswanData.puskeswanImage)
                        tvPuskeswanName.text = puskeswanData.puskeswanName
                        tvPuskeswanAddress.text = puskeswanData.address
                        tvPuskeswanSchedule.text = puskeswanData.workingTime
                    }
                    puskeswanAddress = puskeswanData.puskeswanMaps
                }
                is ApiResponse.Error -> {
                    showCustomToast(result.errorMessage)
                }
                else -> {}
            }
        }
    }

}