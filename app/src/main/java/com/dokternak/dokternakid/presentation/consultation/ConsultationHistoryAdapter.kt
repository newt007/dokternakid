package com.dokternak.dokternakid.presentation.consultation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dokternak.dokternakid.databinding.ItemConsultationBinding
import com.dokternak.dokternakid.domain.article.consultation.model.ConsultationHistory
import com.dokternak.dokternakid.utils.ConstVal.OFFICER_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.setImageUrl

class ConsultationHistoryAdapter : RecyclerView.Adapter<ConsultationHistoryAdapter.ConsultationViewHolder>() {

    private val consultationList = mutableListOf<ConsultationHistory>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<ConsultationHistory>) {
        consultationList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConsultationHistoryAdapter.ConsultationViewHolder {
        val binding =
            ItemConsultationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConsultationViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ConsultationHistoryAdapter.ConsultationViewHolder,
        position: Int
    ) {
        consultationList[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = consultationList.size

    inner class ConsultationViewHolder(private val binding: ItemConsultationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(consultation: ConsultationHistory) {
            binding.apply {
                imgDoctor.setImageUrl(OFFICER_IMAGE_BASE_URL + consultation.photo)
                tvDoctorName.text = consultation.doctorName
                tvComplaint.text = consultation.complaint
                tvDate.text = consultation.date
            }
        }
    }

}