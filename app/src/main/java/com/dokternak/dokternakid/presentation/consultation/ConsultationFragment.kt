package com.dokternak.dokternakid.presentation.consultation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.databinding.FragmentConsultationBinding
import com.dokternak.dokternakid.utils.ConstVal.tabTitle
import com.google.android.material.tabs.TabLayoutMediator

class ConsultationFragment : BaseFragment<FragmentConsultationBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentConsultationBinding = FragmentConsultationBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
        setupTabLayout()
    }

    override fun initAction() {
        binding.apply {
            toolbarConsultation.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }

    private fun setupTabLayout() {
        val consultationPagerAdapter = ConsultationPagerAdapter(requireParentFragment())
        binding.vpConsultation.adapter = consultationPagerAdapter
        TabLayoutMediator(binding.tlConsultation, binding.vpConsultation) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

}