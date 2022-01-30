package com.example.iptnews.view


import MyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.viewpager.widget.ViewPager
import com.example.iptnews.R
import com.google.android.material.tabs.TabLayout



class MainActivity : AppCompatActivity(){

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "IPTNews"
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_fire))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_worldmap))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_soccerball))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_economy))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_politicalscience))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager,
            tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }


}

