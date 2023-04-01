package com.dokternak.dokternakid.presentation.puskeswan.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.databinding.FragmentDetailPuskeswanBinding

class PuskeswanDetailFragment : BaseFragment<FragmentDetailPuskeswanBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailPuskeswanBinding =
        FragmentDetailPuskeswanBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }

}