package br.com.ioasys.ioasysbooks.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.ioasys.ioasysbooks.databinding.FragmentLoginBinding
import br.com.ioasys.ioasysbooks.presentation.viewmodel.LoginViewModel
import br.com.ioasys.ioasysbooks.util.ViewState

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val viewModel : LoginViewModel by viewModels()

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
                viewModel.login(
                    txtFieldEditEmail.text.toString(),
                    txtFieldEditPassword.text.toString()
                )
            }
        }
    }

    private fun addObserver() {
        viewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->

            when(state) {
                is ViewState.Success -> {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToBookListFragment(15)
                    )
                }
                is ViewState.Error -> {
                    binding.txtError.visibility = View.VISIBLE
                }
                is ViewState.loading -> {
                    binding.progressDialog.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}