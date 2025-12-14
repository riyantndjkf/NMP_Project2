package com.example.nmp_project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    val fragments: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        fragments.add(HomeFragment())
        fragments.add(MyFriendsFragment())
        fragments.add(SettingsFragment())

        // 3. Set Adapter untuk ViewPager
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNav.selectedItemId = bottomNav.menu.getItem(position).itemId
            }
        })
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemHome -> viewPager.currentItem = 0 // Pastikan ID ini sama dengan di bottom_menu.xml
                R.id.itemFriends -> viewPager.currentItem = 1 // Pastikan ID ini sama dengan di bottom_menu.xml
                R.id.itemSettings -> viewPager.currentItem = 2 // Pastikan ID ini sama dengan di bottom_menu.xml
            }
            true
        }
    }
}