package com.example.milkyway


import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val navView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val controller = findNavController(R.id.nav_host_main_fragment_1)

        val appBarConfig = AppBarConfiguration(

            setOf(
                R.id.mainFragment,
                R.id.profileFragment
            )
        )

        setupActionBarWithNavController(controller, appBarConfig)
        navView.setupWithNavController(controller)
    }
}