package com.example.deezer.screens.fragments.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.deezer.R

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    var usernameEditText : EditText? = null
    var firstnameEditText : EditText? = null
    var lastnameEditText : EditText? = null
    var passwordEditText : EditText? = null
    var confirmPasswordEditText : EditText? = null

    var registerButton : Button? = null
    var loginTextView : TextView? = null

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        usernameEditText = view.findViewById(R.id.usernameEditText)
        firstnameEditText = view.findViewById(R.id.firstnameEditText)
        lastnameEditText = view.findViewById(R.id.lastnameEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        confirmPasswordEditText = view.findViewById(R.id.confirmPasswordEditText)
        registerButton = view.findViewById(R.id.registerButton)
        loginTextView = view.findViewById(R.id.loginTextView)


        loginTextView?.setOnClickListener{
            findNavController().popBackStack()
        }

        usernameEditText?.addTextChangedListener { checkFormValidity() }
        firstnameEditText?.addTextChangedListener { checkFormValidity() }
        lastnameEditText?.addTextChangedListener { checkFormValidity() }
        passwordEditText?.addTextChangedListener { checkFormValidity() }
        confirmPasswordEditText?.addTextChangedListener { checkFormValidity() }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun checkFormValidity(){
        registerButton?.isEnabled = usernameEditText?.text.toString().isNotEmpty()
                && passwordEditText?.text.toString().isNotEmpty()
                && confirmPasswordEditText?.text.toString().isNotEmpty()
                && firstnameEditText?.text.toString().isNotEmpty()
                && lastnameEditText?.text.toString().isNotEmpty()
                && passwordEditText?.text.toString() == confirmPasswordEditText?.text.toString()
    }

}