package com.dokternak.dokternakid.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentHomeBinding
import com.dokternak.dokternakid.presentation.home.adapter.ArticleAdapter
import com.dokternak.dokternakid.presentation.home.adapter.OfficerAdapter
import com.dokternak.dokternakid.utils.ext.startShimmerLoading
import com.dokternak.dokternakid.utils.ext.stopShimmerLoading
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
        binding.apply {
            rvOfficer.layoutManager = LinearLayoutManager(context)
            rvArticle.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

    }

    override fun initAction() {
    }

    override fun initProcess() {
        homeViewModel.getAllOfficers()
        homeViewModel.getAllArticles()
    }

    override fun initObservers() {
        homeViewModel.getAllOfficers.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {
                    with(binding) {
                        startShimmerLoading(shimmerOfficer, rvOfficer)
                    }
                }
                is ApiResponse.Success -> {
                    with(binding) {
                        stopShimmerLoading(shimmerOfficer, rvOfficer)
                    }
                    val officerAdapter = OfficerAdapter(
                        "Home",
                        onClick = {
                            toDetailOfficer(it.id)
                        },
                    )
                    officerAdapter.setData(result.data)
                    binding.rvOfficer.adapter = officerAdapter
                }
                is ApiResponse.Empty -> {
                    with(binding) {
                        stopShimmerLoading(shimmerOfficer, rvOfficer)
                    }
                }
                is ApiResponse.Error -> {
                    with(binding) {
                        stopShimmerLoading(shimmerOfficer, rvOfficer)
                    }
                }
            }
        }
        homeViewModel.getAllArticles.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {
                    with(binding) {
                        startShimmerLoading(shimmerOfficer, rvArticle)
                    }
                }
                is ApiResponse.Success -> {
                    with(binding) {
                        stopShimmerLoading(shimmerOfficer, rvArticle)
                    }
                    val articleAdapter = ArticleAdapter(onClick = {
                        toDetailArticle(it.articleId)
                    })
                    articleAdapter.setData(result.data)
                    binding.rvArticle.adapter = articleAdapter
                }
                is ApiResponse.Empty -> {
                    with(binding) {
                        stopShimmerLoading(shimmerOfficer, rvArticle)
                    }
                }
                is ApiResponse.Error -> {
                    with(binding) {
                        stopShimmerLoading(shimmerOfficer, rvArticle)
                    }
                }
            }
        }
    }

    private fun toDetailArticle(id: String) {
        val navigateToDetailArticle =
            HomeFragmentDirections.actionHomeFragmentToArticleDetailFragment(id)
        findNavController().navigate(navigateToDetailArticle)
    }

    private fun toDetailOfficer(id: String) {
        val navigateToDetailOfficer =
            HomeFragmentDirections.actionHomeFragmentToOfficerDetailFragment(id)
        findNavController().navigate(navigateToDetailOfficer)
    }

}