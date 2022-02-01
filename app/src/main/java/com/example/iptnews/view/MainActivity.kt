package com.example.iptnews.view


import MyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.iptnews.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout



class MainActivity : AppCompatActivity(){

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this, navController)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        bottomNavigationView.setupWithNavController(navController)



    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)

    }

}

