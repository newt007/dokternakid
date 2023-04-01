package com.dokternak.dokternakid.presentation.puskeswan

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dokternak.dokternakid.databinding.ItemPuskeswanBinding
import com.dokternak.dokternakid.domain.puskeswan.model.Puskeswan
import com.dokternak.dokternakid.utils.ConstVal.PUSKESWAN_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.click
import com.dokternak.dokternakid.utils.ext.setImageUrl

class PuskeswanAdapter(private val onClick: (Puskeswan) -> Unit) : RecyclerView.Adapter<PuskeswanAdapter.PuskeswanViewHolder>() {

    private val puskeswanList = mutableListOf<Puskeswan>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Puskeswan>) {
        puskeswanList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PuskeswanAdapter.PuskeswanViewHolder {
        val binding =
            ItemPuskeswanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PuskeswanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PuskeswanAdapter.PuskeswanViewHolder, position: Int) {
        puskeswanList[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = puskeswanList.size

    inner class PuskeswanViewHolder(private val binding: ItemPuskeswanBinding) :
        ViewHolder(binding.root) {
        fun bind(puskeswan: Puskeswan) {
            binding.apply {
                imgPuskeswan.setImageUrl(PUSKESWAN_IMAGE_BASE_URL + puskeswan.puskeswanImage)
                tvPuskeswanName.text = puskeswan.puskeswanName
                tvPuskeswanAddress.text = puskeswan.address

                root.click {
                    onClick.invoke(puskeswan)
                }
            }
        }
    }

}