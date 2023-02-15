package com.dokternak.dokternakid.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dokternak.dokternakid.R
import com.dokternak.dokternakid.base.BaseFragment
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.databinding.FragmentLoginBinding
import com.dokternak.dokternakid.utils.PreferenceManager
import com.dokternak.dokternakid.utils.ext.*
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val pref: PreferenceManager by inject()
    private val loginViewModel: LoginViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            btnLogin.click {
                val email = binding.edtEmail.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()
                loginUser(email, password)
            }
            btnRegister.click {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        loginViewModel.loginResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiResponse.Loading -> {
                    binding.apply {
                        showLoading(viewDimmer, pbLogin)
                    }
                }
                is ApiResponse.Success -> {
                    binding.apply {
                        hideLoading(viewDimmer, pbLogin)
                    }
                    showCustomToast("Login berhasil")
                }
                is ApiResponse.Error -> {
                    showCustomToast("Email/Password anda salah")
                    binding.apply {
                        hideLoading(viewDimmer, pbLogin)
                    }
                }
                else -> {}
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        when {
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
                loginViewModel.loginUser(email, password)
            }
        }
    }

}