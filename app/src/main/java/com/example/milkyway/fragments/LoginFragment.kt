package com.example.milkyway.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.milkyway.MainActivity2
import com.example.milkyway.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var editTextEmail2: EditText
    private lateinit var editTextPassword2: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewResetPassword : TextView
    private lateinit var textViewSignup : TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = Navigation.findNavController(view)

        editTextEmail2 = view.findViewById(R.id.editTextEmail2)
        editTextPassword2 = view.findViewById(R.id.editTextPassword2)
        buttonLogin = view.findViewById(R.id.buttonLogin)
        textViewResetPassword = view.findViewById(R.id.textViewResetPassword)
        textViewSignup = view.findViewById(R.id.textViewSignUp)

        textViewResetPassword.setOnClickListener(){
            val action = LoginFragmentDirections.actionLoginActivityToResetPasswordActivity2()
            controller.navigate(action)

        }

        textViewSignup.setOnClickListener(){
            val action = LoginFragmentDirections.actionLoginActivityToRegistrationActivity2()
            controller.navigate(action)
        }


        buttonLogin.setOnClickListener{

            val email = editTextEmail2.text.toString()
            val pass = editTextPassword2.text.toString()

            if (email.isEmpty()){
                editTextEmail2.error = "შეიყვანეთ იმეილი"
                return@setOnClickListener
            }else if (!(email.contains("@"))){
                editTextEmail2.error = "იმეილი უნდა შეიცავდეს @ სიმბოლოს"
                return@setOnClickListener
            }else if (pass.isEmpty()){
                editTextPassword2.error = "შეიყვანეთ პაროლი"
                return@setOnClickListener
            }else if (pass.length < 9){
                editTextPassword2.error = "პაროლი უნდა შედგებოდეს არანაკლებ ცხრა სიმბოლოსგან"
                return@setOnClickListener
            }else if (!(pass.matches("(.*[A-Z].*)".toRegex()))||
                !(pass.matches("(.*[0-9].*)".toRegex())) ||
                !(pass.matches("^(?=.*[_.()$&@]).*$".toRegex()))){
                editTextPassword2.error = "პაროლი სუსტია"
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener { task ->
                if(task.isSuccessful){
                    startActivity(Intent(activity,MainActivity2::class.java))
                    activity?.finish()
                }
                else {
                    Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }


}