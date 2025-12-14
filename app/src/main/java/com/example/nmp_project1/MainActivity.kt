package com.example.nmp_project1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.nmp_project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // List fragment yang akan ditampilkan
    private val fragments: ArrayList<Fragment> = arrayListOf(
        HomeFragment(),
        MyFriendsFragment(),
        SettingsFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup ViewPager Adapter (Materi Week 8)
        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }

        // 2. Listener saat BottomNav diklik -> Pindah Halaman ViewPager (Materi Week 9)
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemHome -> binding.viewPager.currentItem = 0
                R.id.itemFriends -> binding.viewPager.currentItem = 1
                R.id.itemSettings -> binding.viewPager.currentItem = 2
            }
            true
        }

        // 3. Callback saat ViewPager digeser -> Update icon aktif di BottomNav
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })
    }
}