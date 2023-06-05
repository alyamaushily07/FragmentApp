package com.example.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener{
    lateinit var page: ViewPager
    lateinit var navbar: NavigationBarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        page = findViewById(R.id.page)
        navbar = findViewById(R.id.navbar)

        val adapter = ViewPageAdapter(initFragments(), supportFragmentManager)
        page.adapter = adapter

        navbar.setOnItemSelectedListener(this)
        page.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
            override fun onPageSelected(position: Int) {
                navbar.menu.getItem(position).setChecked(true)
            }
            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Home -> page.currentItem = 0
            R.id.Destination -> page.currentItem = 1
        }
        return true
    }

    fun initFragments(): ArrayList<Fragment>{
        return arrayListOf(
            Home.newInstance(),
            Destination.newInstance()
        )
    }
}