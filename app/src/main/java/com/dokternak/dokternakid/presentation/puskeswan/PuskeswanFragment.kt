package com.dokternak.dokternakid.presentation.puskeswan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentPuskeswanBinding
import com.dokternak.dokternakid.utils.ext.gone
import com.dokternak.dokternakid.utils.ext.hide
import com.dokternak.dokternakid.utils.ext.show
import org.koin.android.ext.android.inject

class PuskeswanFragment : BaseFragment<FragmentPuskeswanBinding>() {

    private val puskeswanViewModel: PuskeswanViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentPuskeswanBinding = FragmentPuskeswanBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
        puskeswanViewModel.getAllPuskeswan()
    }

    override fun initObservers() {
        puskeswanViewModel.getPuskeswanList.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ApiResponse.Loading -> {
                    isLoading(true)
                }
                is ApiResponse.Success -> {
                    isLoading(false)
                    isEmpty(false)
                    val puskeswanAdapter = PuskeswanAdapter {
                        navigateToPuskeswanDetail(it.puskeswanId.toString())
                    }
                    puskeswanAdapter.setData(result.data)
                    binding.rvPuskeswan.apply {
                        adapter = puskeswanAdapter
                        layoutManager = LinearLayoutManager(context)
                    }
                }
                is ApiResponse.Empty -> {
                    isLoading(false)
                    isEmpty(true)
                }
                else -> {
                    isLoading(false)
                }
            }
        }
    }

    private fun isLoading(loading: Boolean) {
        if (loading) {
            binding.apply {
                pbPuskeswan.show()
                rvPuskeswan.hide()
            }
        } else {
            binding.apply {
                pbPuskeswan.gone()
                rvPuskeswan.show()
            }
        }
    }

    private fun isEmpty(empty: Boolean) {
        if (empty) {
            binding.apply {
                rvPuskeswan.gone()
            }
        } else {
            binding.rvPuskeswan.show()
        }
    }

    private fun navigateToPuskeswanDetail(puskeswan: String) {
        val navigateToPuskesmanDetail = PuskeswanFragmentDirections.actionPuskeswanFragmentToPuskeswanDetailFragment(puskeswan)
        findNavController().navigate(navigateToPuskesmanDetail)
    }

}