package com.dokternak.dokternakid.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.databinding.FragmentProfileBinding
import com.dokternak.dokternakid.utils.BundleKeys
import com.dokternak.dokternakid.utils.ConstVal
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
        setFragmentResultListener(
            ConstVal.EDIT_REQUEST_KEY,
        ) { _, result ->
            val name = result.getString(BundleKeys.BUNDLE_NAME)
            val email = result.getString(BundleKeys.BUNDLE_EMAIL)
            val phone = result.getString(BundleKeys.BUNDLE_PHONE)
            val gender = result.getString(BundleKeys.BUNDLE_GENDER)
            val address = result.getString(BundleKeys.BUNDLE_ADDRESS)
            binding.apply {
                tvEmail.text = email
                tvName.text = name
                tvLocation.text = address
                tvContact.text = phone
                tvGender.text = gender
            }
        }
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