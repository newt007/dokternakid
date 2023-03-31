package com.dokternak.dokternakid.presentation.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dokternak.dokternakid.databinding.ItemLinearArticleBinding
import com.dokternak.dokternakid.domain.article.model.Article
import com.dokternak.dokternakid.utils.ConstVal.ARTICLE_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.click
import com.dokternak.dokternakid.utils.ext.setImageUrl

class ListArticleAdapter(private val onClick: (Article) -> Unit) : RecyclerView.Adapter<ListArticleAdapter.ArticleViewHolder>() {

    private val articleList = mutableListOf<Article>()

    fun setData(newList: List<Article>) {
        articleList.clear()
        articleList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListArticleAdapter.ArticleViewHolder {
        val binding = ItemLinearArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListArticleAdapter.ArticleViewHolder, position: Int) {
        articleList[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = articleList.size

    inner class ArticleViewHolder(val binding: ItemLinearArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.apply {
                imgThumbnail.setImageUrl(ARTICLE_IMAGE_BASE_URL + article.image)
                tvDate.text = article.date
                tvCategory.text = article.articleCategory
                tvTitle.text = article.title
                tvAuthor.text = article.authorName

                root.click {
                    onClick.invoke(article)
                }
            }
        }
    }

}