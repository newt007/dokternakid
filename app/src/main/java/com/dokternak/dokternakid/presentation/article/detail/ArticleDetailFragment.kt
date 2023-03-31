package com.dokternak.dokternakid.presentation.article.detail

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentDetailArticleBinding
import com.dokternak.dokternakid.domain.article.model.Article
import com.dokternak.dokternakid.utils.ConstVal.ARTICLE_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.click
import com.dokternak.dokternakid.utils.ext.setImageUrl
import com.dokternak.dokternakid.utils.ext.showCustomToast
import org.koin.android.ext.android.inject

class ArticleDetailFragment : BaseFragment<FragmentDetailArticleBinding>() {

    private var articleId: String? = null

    private val articleDetailViewModel: ArticleDetailViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailArticleBinding =
        FragmentDetailArticleBinding.inflate(inflater, container, false)

    override fun initIntent() {
        articleId = arguments?.getString("articleId")
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
        articleDetailViewModel.getArticleDetail(articleId.toString())
    }

    override fun initObservers() {
        articleDetailViewModel.detailArticle.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ApiResponse.Loading -> {

                }
                is ApiResponse.Success -> {
                    val articleData = result.data
                    setData(articleData)
                }
                is ApiResponse.Error -> {
                    showCustomToast(result.errorMessage)
                }
                else -> {}
            }
        }
    }

    private fun setData(article: Article) {
        binding.apply {
            imgThumbnail.setImageUrl(ARTICLE_IMAGE_BASE_URL + article.image)
            tvArticleCategory.text = article.articleCategory
            tvArticleDate.text = article.date
            tvArticleAuthor.text = article.authorName
            tvArticleTitle.text = article.title
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                tvArticleContent.text = Html.fromHtml(article.content, Html.FROM_HTML_MODE_COMPACT)
            } else {
                tvArticleContent.text = Html.fromHtml(article.content)
            }
            tvArticleSource.text = article.source
        }
    }

}