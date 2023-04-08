package com.dokternak.dokternakid.presentation.profile.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentEditProfileBinding
import com.dokternak.dokternakid.domain.membership.model.User
import com.dokternak.dokternakid.utils.BundleKeys
import com.dokternak.dokternakid.utils.ConstVal
import com.dokternak.dokternakid.utils.PreferenceManager
import com.dokternak.dokternakid.utils.ext.click
import com.dokternak.dokternakid.utils.ext.gone
import com.dokternak.dokternakid.utils.ext.show
import com.dokternak.dokternakid.utils.ext.showCustomToast
import org.koin.android.ext.android.inject

class EditProfileFragment : BaseFragment<FragmentEditProfileBinding>() {

    private val prefManager: PreferenceManager by lazy { PreferenceManager(requireContext()) }

    private val editProfileViewModel: EditProfileViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentEditProfileBinding = FragmentEditProfileBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
        binding.apply {
            prefManager.let {
                edtUserName.setText(it.name ?: "")
                edtUserEmail.setText(it.email ?: "")
                edtUserPhone.setText(it.phoneNumber ?: "")
                edtUserAddress.setText(it.location ?: "")

                it.gender?.let { gender ->
                    if (gender == getString(R.string.label_male)) {
                        binding.rbMale.isChecked = true
                    } else {
                        binding.rbFemale.isChecked = true
                    }
                }
            }
        }
    }

    override fun initAction() {
        binding.btnEditProfile.click {
            editProfile()
        }
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        editProfileViewModel.profileResult.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ApiResponse.Loading -> {
                    isLoading(true)
                }
                is ApiResponse.Success -> {
                    isLoading(false)
                    sendResult(result.data)
                    showCustomToast(getString(R.string.message_edit_profile_success))
                    findNavController().navigateUp()
                }
                is ApiResponse.Error -> {
                    isLoading(false)
                    showCustomToast(result.errorMessage)
                }
                else -> {
                    isLoading(false)
                }
            }
        }
    }

    private fun editProfile() {
        val name = binding.edtUserName.text.toString()
        val email = binding.edtUserEmail.text.toString()
        val phone = binding.edtUserPhone.text.toString()
        val address = binding.edtUserAddress.text.toString()
        val selectedRadioButtonId = binding.rgGender.checkedRadioButtonId
        val selectedRadioButton = view?.findViewById<RadioButton>(selectedRadioButtonId)
        val selectedGender = selectedRadioButton?.text.toString()

        when {
            name.isEmpty() -> {
                binding.edtUserName.apply {
                    error = context.getString(R.string.warning_name_must_not_be_empty)
                    requestFocus()
                }
            }
            email.isEmpty() -> {
                binding.edtUserEmail.apply {
                    error = context.getString(R.string.warning_email_must_not_be_empty)
                    requestFocus()
                }
            }
            phone.isEmpty() -> {
                binding.edtUserPhone.apply {
                    error = context.getString(R.string.warning_phone_must_not_be_empty)
                    requestFocus()
                }
            }
            address.isEmpty() -> {
                binding.edtUserAddress.apply {
                    error = context.getString(R.string.warning_address_must_not_be_empty)
                    requestFocus()
                }
            }
            else -> {
                editProfileViewModel.editProfile(
                    id = prefManager.id.toString().toInt(),
                    name = name,
                    password = prefManager.password.toString(),
                    email = email,
                    phoneNumber = phone,
                    gender = selectedGender,
                    address = address,
                    profilePicture = prefManager.profilePicture.toString()
                )
            }
        }
    }

    private fun isLoading(loading: Boolean) {
        if (loading) {
            binding.apply {
                pbEditProfile.show()
                bgDimmer.show()
            }
        } else {
            binding.apply {
                pbEditProfile.gone()
                bgDimmer.gone()
            }
        }
    }

    private fun sendResult(user: User) {
        val bundle = Bundle().apply {
            putString(BundleKeys.BUNDLE_NAME, user.name)
            putString(BundleKeys.BUNDLE_EMAIL, user.email)
            putString(BundleKeys.BUNDLE_GENDER, user.gender)
            putString(BundleKeys.BUNDLE_ADDRESS, user.address)
            putString(BundleKeys.BUNDLE_PHONE, user.phoneNumber)
        }
        parentFragmentManager.setFragmentResult(ConstVal.EDIT_REQUEST_KEY, bundle)
    }

}