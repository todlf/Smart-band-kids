package com.example.smart_band_kids

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    val fragments = listOf<Fragment>(HomeFragment(), BluetoothFragment(), NotificationFragment(), SettingFragment())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}