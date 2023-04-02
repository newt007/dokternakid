package com.dokternak.dokternakid.presentation.consultation.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentInboxConsultationBinding
import com.dokternak.dokternakid.presentation.consultation.ConsultationHistoryAdapter
import com.dokternak.dokternakid.utils.ext.gone
import com.dokternak.dokternakid.utils.ext.hideLoading
import com.dokternak.dokternakid.utils.ext.show
import com.dokternak.dokternakid.utils.ext.showLoading
import org.koin.android.ext.android.inject

class InboxConsultationFragment : BaseFragment<FragmentInboxConsultationBinding>() {

    private val inboxConsultationViewModel: InboxConsultationViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentInboxConsultationBinding =
        FragmentInboxConsultationBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
        inboxConsultationViewModel.getInboxConsultation()
    }

    override fun initObservers() {
        inboxConsultationViewModel.inboxConsultationResult.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ApiResponse.Loading -> {
                    showLoading(binding.pbConsultation)
                }
                is ApiResponse.Success -> {
                    hideLoading(binding.pbConsultation)
                    isEmpty(false)
                    val consultationAdapter = ConsultationHistoryAdapter()
                    consultationAdapter.setData(result.data)
                    binding.rvInboxConsultation.apply {
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