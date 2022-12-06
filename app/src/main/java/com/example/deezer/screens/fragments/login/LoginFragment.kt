package com.example.deezer.screens.fragments.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.deezer.R
import com.example.deezer.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    var usernameEditText : EditText? = null
    var passwordEditText: EditText? = null
    var loginButton: Button? = null
    var registerTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        usernameEditText = this.view?.findViewById(R.id.usernameEditText)
        passwordEditText = this.view?.findViewById(R.id.passwordEditText)
        loginButton = this.view?.findViewById(R.id.loginButton)
        registerTextView = this.view?.findViewById(R.id.registerTextView)

        loginButton?.setOnClickListener{
            val username = usernameEditText?.text.toString()
            val password = passwordEditText?.text.toString()
        }

        registerTextView?.setOnClickListener{
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }


        super.onViewCreated(view, savedInstanceState)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }
}