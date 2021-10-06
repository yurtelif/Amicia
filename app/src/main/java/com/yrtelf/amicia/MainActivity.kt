package com.yrtelf.amicia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yrtelf.amicia.databinding.ActivityMainBinding
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        bottomNavigationView = activityMainBinding.bttmNav
        NavigationUI.setupWithNavController(bottomNavigationView, findNavController(this, R.id.nav_host_fragment))
    }
}
