package com.dokternak.dokternakid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dokternak.dokternakid.databinding.ActivityMainBinding
import com.dokternak.dokternakid.utils.ext.gone
import com.dokternak.dokternakid.utils.ext.show

class MainActivity : AppCompatActivity() {

    private lateinit var _activityMainBinding: ActivityMainBinding
    private val binding get() = _activityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_activityMainBinding.root)

        initUI()
    }

    private fun initUI() {
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navHostBottomBar = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navControllerBottomBar = navHostBottomBar.navController

        binding.mainBottomNavigation.setupWithNavController(navControllerBottomBar)
        navControllerBottomBar.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment || destination.id == R.id.profileFragment) {
                binding.mainBottomNavigation.show()
            } else {
                binding.mainBottomNavigation.gone()
            }
        }
    }

}