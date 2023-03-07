package com.dokternak.dokternakid.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dokternak.dokternakid.databinding.ItemOfficerBinding
import com.dokternak.dokternakid.domain.officer.model.Officer
import com.dokternak.dokternakid.utils.ConstVal.OFFICER_IMAGE_BASE_URL
import com.dokternak.dokternakid.utils.ext.click
import com.dokternak.dokternakid.utils.ext.setImageUrl

class OfficerAdapter(val page: String, private val onClick: (Officer) -> Unit) : RecyclerView.Adapter<OfficerAdapter.OfficerViewHolder>() {

    private val officerList = mutableListOf<Officer>()

    fun setData(list: List<Officer>) {
        officerList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficerViewHolder {
        val binding = ItemOfficerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfficerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OfficerViewHolder, position: Int) {
        holder.bind(officerList[position])
    }

    override fun getItemCount(): Int = if (page == "Home") 3 else officerList.size

    inner class OfficerViewHolder(
        private val binding: ItemOfficerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(officer: Officer) {
            binding.apply {
                imgOfficerProfile.setImageUrl(OFFICER_IMAGE_BASE_URL + officer.photo)
                tvDoctorName.text = officer.doctorName
                tvPosition.text = officer.position
                tvLocation.text = officer.address

                root.click {
                    onClick.invoke(officer)
                }
            }
        }
    }

}