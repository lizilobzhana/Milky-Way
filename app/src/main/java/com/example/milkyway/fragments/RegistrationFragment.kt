package com.example.milkyway.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.milkyway.R

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private lateinit var editTextUsername: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPasswordAgain: EditText
    private lateinit var buttonRegistration: Button
    private lateinit var textViewLogin: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = Navigation.findNavController(view)

        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextEmail = view.findViewById(R.id.editTextPassword)
        editTextPasswordAgain = view.findViewById(R.id.editTextPasswordAgain)

        textViewLogin = view.findViewById(R.id.textViewLogin)
        buttonRegistration = view.findViewById(R.id.buttonRegistration)

        textViewLogin.setOnClickListener{
            val action = RegistrationFragmentDirections.actionRegistrationActivityToLoginActivity()
            controller.navigate(action)
        }

        buttonRegistration.setOnClickListener{
            val username = editTextUsername.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val passwordAgain = editTextPasswordAgain.text.toString().trim()

            if (username.isEmpty()){
                editTextUsername.error = "შეიყვანეთ მომხმარებლის სახელი"
            }else if (email.isEmpty()){
                editTextEmail.error = "შეიყვანეთ იმეილი"
                return@setOnClickListener
            }else if (!(email.contains("@"))){
                editTextEmail.error = "იმეილი უნდა შეიცავდეს @ სიმბოლოს"
                return@setOnClickListener
            }else if (password.isEmpty()){
                editTextPassword.error = "შეიყვანეთ პაროლი"
                return@setOnClickListener
            }else if (password.length < 9){
                editTextPassword.error = "პაროლი უნდა შედგებოდეს არანაკლებ ცხრა სიმბოლოსგან"
                return@setOnClickListener
            }else if (!(password.matches("(.*[A-Z].*)".toRegex()))||
                !(password.matches("(.*[0-9].*)".toRegex())) ||
                !(password.matches("^(?=.*[_.()$&@]).*$".toRegex()))){
                editTextPassword.error = "პაროლი სუსტია"
                return@setOnClickListener
            }else if (passwordAgain != password) {
                editTextPasswordAgain.error = "პაროლები არ ემთხვევა ერთმანეთს"
                return@setOnClickListener
            }else if (passwordAgain.isEmpty()){
                editTextPasswordAgain.error = "შეიყვანეთ პაროლი განმეორებით"
            }
        }
    }
}