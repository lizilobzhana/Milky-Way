package com.example.milkyway.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.milkyway.R
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordFragment : Fragment(R.layout.fragment_resetpassword) {
    private lateinit var editTextEmail3: EditText
    private lateinit var buttonSendEmail: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextEmail3 = view.findViewById(R.id.editTextEmail3)
        buttonSendEmail = view.findViewById(R.id.buttonSendEmail)


        buttonSendEmail.setOnClickListener {
            val email = editTextEmail3.text.toString()
            if (email.isEmpty()) {
                editTextEmail3.error = "შეიყვანეთ იმეილი"
                return@setOnClickListener
            }
            if (!(email.contains("@"))) {
                editTextEmail3.error = "იმეილი უნდა შეიცავდეს @ სიმბოლოს"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(getActivity(), "password sent on email", Toast.LENGTH_SHORT)
                        .show()
                }else{
                    Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show()
                }


            }


        }
    }
}