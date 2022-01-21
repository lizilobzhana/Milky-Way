package com.example.milkyway.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.milkyway.R

class ResetPasswordFragment : Fragment(R.layout.fragment_resetpassword) {
    private lateinit var editTextEmail3: EditText
    private lateinit var buttonSendEmail: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextEmail3 = view.findViewById(R.id.editTextEmail3)
        buttonSendEmail = view.findViewById(R.id.buttonSendEmail)


    }


}