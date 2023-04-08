package com.dokternak.dokternakid.presentation.officer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentOfficerBinding
import com.dokternak.dokternakid.presentation.home.adapter.OfficerAdapter
import com.dokternak.dokternakid.utils.ext.gone
import com.dokternak.dokternakid.utils.ext.hide
import com.dokternak.dokternakid.utils.ext.show
import org.koin.android.ext.android.inject

class OfficerFragment : BaseFragment<FragmentOfficerBinding>() {

    private val officerViewModel: OfficerViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentOfficerBinding = FragmentOfficerBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {

    }

    override fun initAction() {
        binding.svOfficer.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                officerViewModel.getSearchOfficers(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun initProcess() {
        officerViewModel.getSearchOfficers("")
    }

    override fun initObservers() {
        officerViewModel.searchOfficerResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {
                    isLoading(true)
                }
                is ApiResponse.Success -> {
                    isLoading(false)
                    isEmpty(false)
                    val officerAdapter = OfficerAdapter("officer") {
                        toDetailOfficer(it.doctorId.toString())
                    }
                    officerAdapter.setData(result.data)
                    binding.rvOfficer.apply {
                        adapter = officerAdapter
                        layoutManager = LinearLayoutManager(context)
                    }
                }
                is ApiResponse.Empty -> {
                    isLoading(false)
                    isEmpty(true)
                }
                is ApiResponse.Error -> {
                    isLoading(false)
                }
            }
        }
    }

    private fun isLoading(loading: Boolean) {
        if (loading) {
            binding.apply {
                pbOfficer.show()
                rvOfficer.hide()
            }
        } else {
            binding.apply {
                pbOfficer.gone()
                rvOfficer.show()
            }
        }
    }

    private fun isEmpty(empty: Boolean) {
        if (empty) {
            binding.apply {
                rvOfficer.gone()
                layoutEmpty.show()
            }
        } else {
            binding.rvOfficer.show()
            binding.layoutEmpty.gone()
        }
    }

    private fun toDetailOfficer(officerId: String) {
        val navigateToDetailOfficer =
            OfficerFragmentDirections.actionOfficerFragmentToOfficerDetailFragment(officerId)
        findNavController().navigate(navigateToDetailOfficer)
    }

}