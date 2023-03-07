package com.dokternak.dokternakid.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.databinding.FragmentSplashScreenBinding
import com.dokternak.dokternakid.utils.ConstVal.SPLASH_DELAY_TIME
import com.dokternak.dokternakid.utils.PreferenceManager
import org.koin.android.ext.android.inject

class SplashFragment: BaseFragment<FragmentSplashScreenBinding>() {

    private val pref: PreferenceManager by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSplashScreenBinding = FragmentSplashScreenBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
        val isLogin = pref.isLogin

        Handler(Looper.getMainLooper()).postDelayed({
            when(isLogin) {
                false -> findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                true -> findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }, SPLASH_DELAY_TIME)
    }

    override fun initObservers() {
    }
}