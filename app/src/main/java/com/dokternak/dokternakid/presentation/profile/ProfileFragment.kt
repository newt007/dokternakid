package com.dokternak.dokternakid.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.databinding.FragmentProfileBinding
import com.dokternak.dokternakid.utils.PreferenceManager
import com.dokternak.dokternakid.utils.ext.click
import com.dokternak.dokternakid.utils.ext.showConfirmDialog

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val prefManager: PreferenceManager by lazy { PreferenceManager(requireContext()) }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
        prefManager.let {
            binding.apply {
                imgProfile.setImageDrawable(
                    AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.bg_gunung
                    )
                )
                tvEmail.text = it.email
                tvName.text = it.name
                tvLocation.text = it.location
                tvContact.text = it.phoneNumber
                tvGender.text = it.gender
            }
        }
    }

    override fun initAction() {
        binding.apply {
            btnLogout.click {
                showConfirmDialog(
                    title = getString(R.string.title_information),
                    message = getString(R.string.message_logout_confirmation),
                    onPositiveClick = {
                        prefManager.clearAllPreferences()
                        findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
                    }
                )
            }
            btnEditProfile.click {
                findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }

}