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
import com.example.milkyway.MainActivity
import com.example.milkyway.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var textViewUsername : EditText
    private lateinit var buttonChangePassword2 : Button
    private lateinit var buttonLogout : Button
    private lateinit var buttonSave : Button
    private lateinit var textViewUsername1: EditText



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        textViewUsername = view.findViewById(R.id.textViewUsername)
        buttonChangePassword2 = view.findViewById(R.id.buttonChangePassword2)
        buttonLogout = view.findViewById(R.id.buttonLogout)
        textViewUsername1 = view.findViewById(R.id.textViewUsername1)
        buttonSave = view.findViewById(R.id.buttonSave)








                logoutListener()
                changePass()











    }
    private fun logoutListener(){
        buttonLogout.setOnClickListener() {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }
    }

    private fun changePass(){
        buttonChangePassword2.setOnClickListener {
            val controller = view?.let { Navigation.findNavController(it) }

            val action = ProfileFragmentDirections.actionProfileFragmentToChangePasswordFragment()
            controller?.navigate(action)
        }
    }






}


