package com.indialone.indieapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.indialone.indieapp.R
import com.indialone.indieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val navHostController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        navController = navHostController!!.findNavController()

        appBarConfiguration = AppBarConfiguration(
            navGraph = navController.graph,
            drawerLayout = mBinding.drawerLayout
        )

        mBinding.navigationView.setupWithNavController(navController)

        setupActionBarWithNavController( navController, appBarConfiguration)
//        NavigationUI.setupWithNavController(mBinding.navigationView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }

}