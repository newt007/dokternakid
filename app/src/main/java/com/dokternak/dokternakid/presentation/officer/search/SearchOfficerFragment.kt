package com.dokternak.dokternakid.presentation.officer.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentSearchOfficerBinding
import com.dokternak.dokternakid.domain.officer.model.Officer
import com.dokternak.dokternakid.presentation.home.adapter.OfficerAdapter
import com.dokternak.dokternakid.utils.BundleKeys.BUNDLE_OFFICER
import com.dokternak.dokternakid.utils.ConstVal.OFFICER_REQUEST_KEY
import com.dokternak.dokternakid.utils.ext.hideLoading
import com.dokternak.dokternakid.utils.ext.show
import com.dokternak.dokternakid.utils.ext.showCustomToast
import com.dokternak.dokternakid.utils.ext.showLoading
import org.koin.android.ext.android.inject

class SearchOfficerFragment : BaseFragment<FragmentSearchOfficerBinding>() {

    private val searchOfficerViewModel: SearchOfficerViewModel by inject()

    private val officerAdapter: OfficerAdapter by lazy {
        OfficerAdapter("officer") {
            sendResult(it)
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSearchOfficerBinding =
        FragmentSearchOfficerBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.svOfficer.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchOfficerViewModel.searchOfficer(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun initProcess() {
        searchOfficerViewModel.searchOfficer("")
    }

    override fun initObservers() {
        searchOfficerViewModel.searchOfficerResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {
                    showLoading(binding.pbOfficer)
                }
                is ApiResponse.Success -> {
                    hideLoading(binding.pbOfficer)
                    officerAdapter.setData(result.data)
                    binding.rvOfficer.apply {
                        adapter = officerAdapter
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
                is ApiResponse.Empty -> {
                    hideLoading(binding.pbOfficer)
                    binding.layoutEmpty.show()
                }
                is ApiResponse.Error -> {
                    showCustomToast(result.errorMessage)
                    hideLoading(binding.pbOfficer)
                }
            }
        }
    }

    private fun sendResult(officer: Officer) {
        val bundle = Bundle().apply {
            putParcelable(BUNDLE_OFFICER, officer)
        }
        parentFragmentManager.setFragmentResult(OFFICER_REQUEST_KEY, bundle)

        findNavController().navigateUp()
    }

}