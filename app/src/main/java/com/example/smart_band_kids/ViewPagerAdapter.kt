package com.example.smart_band_kids

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val sensorData: Map<String, Float?>
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = listOf<Fragment>(
        HomeFragment.newInstance(sensorData),
        BluetoothFragment(),
        NotificationFragment(),
        SettingFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}