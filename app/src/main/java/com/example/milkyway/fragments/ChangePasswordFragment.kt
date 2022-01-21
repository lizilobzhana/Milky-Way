package com.example.milkyway.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.milkyway.R

class ChangePasswordFragment : Fragment(R.layout.fragment_changepassword) {
    private lateinit var editTextCurrentPassword : EditText
    private lateinit var editTextNewPassword : EditText
    private lateinit var editTextNewPasswordAgain : EditText
    private lateinit var buttonChangePassword: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextCurrentPassword =view.findViewById(R.id.editTextCurrentPassword)
        editTextNewPassword= view.findViewById(R.id.editTextNewPassword)
        editTextNewPasswordAgain = view.findViewById(R.id.editTextNewPasswordAgain)
        buttonChangePassword = view.findViewById(R.id.buttonChangePassword)

    }
}