package com.dokternak.dokternakid.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dokternak.dokternakid.databinding.ItemArticleBinding
import com.dokternak.dokternakid.domain.article.model.Article
import com.dokternak.dokternakid.utils.ConstVal.ARTICLE_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.setImageUrl

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private val articleList = mutableListOf<Article>()

    fun setData(list: List<Article>) {
        articleList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount(): Int = articleList.size

    inner class ArticleViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.apply {
                imgThumbnail.setImageUrl(ARTICLE_IMAGE_BASE_URL + article.image)
                tvTitle.text = article.title
                tvAuthor.text = article.authorName
                tvCategory.text = article.articleCategory
                tvDate.text = article.date
            }
        }
    }

}