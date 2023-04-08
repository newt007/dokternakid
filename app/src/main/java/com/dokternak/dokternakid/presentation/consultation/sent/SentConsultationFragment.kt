package com.dokternak.dokternakid.presentation.consultation.sent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentSentConsultationBinding
import com.dokternak.dokternakid.domain.consultation.model.Consultation
import com.dokternak.dokternakid.presentation.consultation.ConsultationFragmentDirections
import com.dokternak.dokternakid.presentation.consultation.adapter.ConsultationAdapter
import com.dokternak.dokternakid.utils.BundleKeys.BUNDLE_REFRESH
import com.dokternak.dokternakid.utils.ConstVal
import com.dokternak.dokternakid.utils.ConstVal.SENT_CONSULTATION
import com.dokternak.dokternakid.utils.ext.*
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
        setFragmentResultListener(
            ConstVal.REFRESH_REQUEST_KEY,
        ) { _, result ->
            val key = result.getString(BUNDLE_REFRESH)
            if (key == "refresh") {
                sentConsultationViewModel.getSentConsultations()
            }
        }
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            fabNewConsultation.click {
                findNavController().navigate(R.id.action_consultationFragment_to_addConsultationFragment)
            }
        }
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
                    val consultationAdapter = ConsultationAdapter {
                        toDetailConsultation(it)
                    }
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
                rvSentConsultation.gone()
                layoutEmpty.show()
            }
        } else {
            binding.apply {
                rvSentConsultation.show()
                layoutEmpty.gone()
            }
        }
    }

    private fun toDetailConsultation(consultation: Consultation) {
        val navigateToDetail = ConsultationFragmentDirections.actionConsultationFragmentToDetailConsultationFragment(
            consultation.consultationId.toString(),
            SENT_CONSULTATION
        )
        findNavController().navigate(navigateToDetail)
    }

}