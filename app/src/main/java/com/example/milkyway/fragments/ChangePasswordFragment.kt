package com.example.milkyway.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.milkyway.R
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordFragment : Fragment(R.layout.fragment_changepassword) {
    private lateinit var editTextNewPasswordAgain : EditText
    private lateinit var editTextNewPasswordAgain1 : EditText
    private lateinit var buttonChangePassword: Button
    val controller = view?.let { it1 -> Navigation.findNavController(it1) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        editTextNewPasswordAgain= view.findViewById(R.id.editTextNewPasswordAgain)
        editTextNewPasswordAgain1= view.findViewById(R.id.editTextNewPasswordAgain1)
        buttonChangePassword = view.findViewById(R.id.buttonChangePassword)


        buttonChangePassword.setOnClickListener {
            val password = editTextNewPasswordAgain.text.toString()
            val againPassword = editTextNewPasswordAgain1.text.toString()

            if (password.isEmpty()){
                editTextNewPasswordAgain.error = "შეიყვანეთ პაროლი"
                return@setOnClickListener
            }
            if (password.length < 9){
                editTextNewPasswordAgain.error = "პაროლი უნდა შედგებოდეს არანაკლებ ცხრა სიმბოლოსგან"
                return@setOnClickListener
            }
            if (!(password.matches("(.*[A-Z].*)".toRegex()))||
                !(password.matches("(.*[0-9].*)".toRegex())) ||
                !(password.matches("^(?=.*[_.()$&@]).*$".toRegex()))){
                editTextNewPasswordAgain.error = "პაროლი სუსტია"
                return@setOnClickListener
            }
            if (againPassword != password) {
                editTextNewPasswordAgain1.error = "პაროლები არ ემთხვევა ერთმანეთს"
                return@setOnClickListener
            }
            if (againPassword.isEmpty()){
                editTextNewPasswordAgain1.error = "შეიყვანეთ პაროლი განმეორებით"
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(password)
                ?.addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(activity, "Successfully changed password", Toast.LENGTH_SHORT).show()
                        val action = ChangePasswordFragmentDirections.actionChangePasswordFragmentToProfileFragment()
                        controller?.navigate(action)
                    } else {
                        Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}