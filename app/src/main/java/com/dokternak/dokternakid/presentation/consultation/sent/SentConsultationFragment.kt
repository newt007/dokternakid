package com.dokternak.dokternakid.presentation.consultation.sent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentSentConsultationBinding
import com.dokternak.dokternakid.presentation.consultation.ConsultationAdapter
import com.dokternak.dokternakid.utils.ext.gone
import com.dokternak.dokternakid.utils.ext.hideLoading
import com.dokternak.dokternakid.utils.ext.show
import com.dokternak.dokternakid.utils.ext.showLoading
import org.koin.android.ext.android.inject

class SentConsultationFragment : BaseFragment<FragmentSentConsultationBinding>() {

    private val sentConsultationViewModel: SentConsultationViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSentConsultationBinding =
        FragmentSentConsultationBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
        sentConsultationViewModel.getSentConsultations()
    }

    override fun initObservers() {
        sentConsultationViewModel.sentConsultationResult.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ApiResponse.Loading -> {
                    showLoading(binding.pbConsultation)
                }
                is ApiResponse.Success -> {
                    hideLoading(binding.pbConsultation)
                    isEmpty(false)
                    val consultationAdapter = ConsultationAdapter()
                    consultationAdapter.setData(result.data)
                    binding.rvSentConsultation.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = consultationAdapter
                    }
                }
                is ApiResponse.Empty -> {
                    isEmpty(true)
                    hideLoading(binding.pbConsultation)
                }
                else -> {
                    isEmpty(true)
                }
            }
        }
    }

    private fun isEmpty(empty: Boolean) {
        if (empty) {
            binding.apply {
                layoutEmpty.show()
            }
        } else {
            binding.apply {
                layoutEmpty.gone()
            }
        }
    }

}