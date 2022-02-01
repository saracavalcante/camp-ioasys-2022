package br.com.ioasys.ioasysbooks.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.ioasys.ioasysbooks.databinding.FragmentLoginBinding
import br.com.ioasys.ioasysbooks.presentation.viewmodel.LoginViewModel
import br.com.ioasys.ioasysbooks.util.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val loginViewModel : LoginViewModel by lazy {
        getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
        addObserver()
    }

    private fun setOnClickListener() {
        binding.enterButton.setOnClickListener {
            binding.run {
                loginViewModel.login(
                    txtFieldEditEmail.text.toString(),
                    txtFieldEditPassword.text.toString()
                )

                txtFieldEditEmail.addTextChangedListener {
                    txtError.visibility = View.GONE
                }
                txtFieldEditPassword.addTextChangedListener {
                    txtError.visibility = View.GONE
                }
            }
        }
    }

    private fun addObserver() {
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->

            when(state) {
                is ViewState.Success -> {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToBookListFragment()
                    )
                }
                is ViewState.Error -> {
                    binding.txtError.text = state.throwable.message
                    binding.progressDialog.visibility = View.GONE
                    binding.txtError.visibility = View.VISIBLE
                }
                is ViewState.loading -> {
                    binding.progressDialog.visibility = View.VISIBLE
                }
                else -> Unit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }
}