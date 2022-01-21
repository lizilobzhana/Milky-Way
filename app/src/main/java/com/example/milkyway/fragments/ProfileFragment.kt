package com.example.milkyway.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.milkyway.MainActivity
import com.example.milkyway.R
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var textViewUsername : TextView
    private lateinit var buttonChangePassword2 : Button
    private lateinit var buttonLogout : Button
    val controller = view?.let { Navigation.findNavController(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewUsername = view.findViewById(R.id.textViewUsername)
        buttonChangePassword2 = view.findViewById(R.id.buttonChangePassword2)
        buttonLogout = view.findViewById(R.id.buttonLogout)


        buttonLogout.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity,MainActivity::class.java))
            activity?.finish()
        }

        buttonChangePassword2.setOnClickListener{

            val action = ProfileFragmentDirections.actionProfileFragmentToChangePasswordFragment()
            controller?.navigate(action)
        }


    }
}