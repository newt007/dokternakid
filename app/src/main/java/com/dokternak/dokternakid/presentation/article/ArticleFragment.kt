package com.dokternak.dokternakid.presentation.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentArticleBinding
import com.dokternak.dokternakid.presentation.article.detail.ArticleViewModel
import com.dokternak.dokternakid.utils.ext.gone
import com.dokternak.dokternakid.utils.ext.hide
import com.dokternak.dokternakid.utils.ext.show
import org.koin.android.ext.android.inject

class ArticleFragment : BaseFragment<FragmentArticleBinding>() {

    private val articleViewModel: ArticleViewModel by inject()

    private var articleId: String? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentArticleBinding = FragmentArticleBinding.inflate(inflater, container, false)

    override fun initIntent() {
        articleId = arguments?.getString("articleId")
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.svArticle.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                articleViewModel.searchArticle(query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun initProcess() {
        articleViewModel.searchArticle("")
    }

    override fun initObservers() {
        articleViewModel.searchArticlesResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {
                    isLoading(true)
                }
                is ApiResponse.Success -> {
                    isLoading(false)
                    isEmpty(false)
                    val articleAdapter = ListArticleAdapter {
                        toDetailArticle(it.articleId)
                    }
                    articleAdapter.setData(result.data)
                    binding.rvArticle.apply {
                        adapter = articleAdapter
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
                pbArticle.show()
                rvArticle.hide()
            }
        } else {
            binding.apply {
                pbArticle.gone()
                rvArticle.show()
            }
        }
    }

    private fun isEmpty(empty: Boolean) {
        if (empty) {
            binding.apply {
                rvArticle.gone()
            }
        } else {
            binding.rvArticle.show()
        }
    }

    private fun toDetailArticle(articleId: String) {
        val navigateToDetailArticle =
            ArticleFragmentDirections.actionArticleFragment2ToArticleDetailFragment(articleId)
        findNavController().navigate(navigateToDetailArticle)
    }

}