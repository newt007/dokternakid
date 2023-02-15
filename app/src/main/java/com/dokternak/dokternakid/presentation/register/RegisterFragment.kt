package com.dokternak.dokternakid.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentRegisterBinding
import com.dokternak.dokternakid.utils.ext.*
import org.koin.android.ext.android.inject

class RegisterFragment: BaseFragment<FragmentRegisterBinding>() {

    private val registerViewModel: RegisterViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentRegisterBinding = FragmentRegisterBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            btnRegister.click {
                val name = edtFullName.text.toString()
                val email = edtEmail.text.toString()
                val password = edtPassword.text.toString()

                registerUser(name, email, password)
            }
            btnLogin.click {
                findNavController().popBackStack()
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        registerViewModel.registerResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {
                    binding.apply {
                        showLoading(viewDimmer, pbRegister)
                    }
                }
                is ApiResponse.Success -> {
                    binding.apply {
                        hideLoading(viewDimmer, pbRegister)
                    }
                    showCustomToast("Register Berhasil")
                    findNavController().popBackStack()
                }
                is ApiResponse.Error -> {
                    showCustomToast(result.errorMessage)
                    binding.apply {
                        hideLoading(viewDimmer, pbRegister)
                    }
                }
                else -> {}
            }
        }
    }

    private fun registerUser(name: String, email: String, password: String) {
        when {
            name.isEmpty() -> {
                binding.edtFullName.showMessage(getString(R.string.message_name_cant_empty))
            }
            email.isNotValidEmail() -> {
                binding.edtEmail.showMessage(getString(R.string.message_email_is_not_valid))
            }
            email.isEmpty() -> {
                binding.edtEmail.showMessage(getString(R.string.message_email_cant_empty))
            }
            password.isEmpty() -> {
                binding.edtPassword.showMessage(getString(R.string.message_password_cant_empty))
            }
            else -> {
                registerViewModel.registerUser(name, email, password)
            }
        }
    }

}