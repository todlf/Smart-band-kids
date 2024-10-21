package com.example.smart_band_kids

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.smart_band_kids.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sensorData = getSensorDataFromIntent()
        initViewPager(sensorData)
        initNavigation()
    }

    private fun getSensorDataFromIntent(): Map<String, Float?> {
        return mapOf(
            "water" to intent.getFloatExtra("water", Float.NaN),
            "accelX" to intent.getFloatExtra("accelX", Float.NaN),
            "accelY" to intent.getFloatExtra("accelY", Float.NaN),
            "accelZ" to intent.getFloatExtra("accelZ", Float.NaN)
        )
    }

    private fun initViewPager(sensorData: Map<String, Float?>) {
        val viewPager = binding.viewPager
        viewPagerAdapter = ViewPagerAdapter(this, sensorData)
        viewPager.adapter = viewPagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNavigation.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> {
                    binding.viewPager.currentItem = 0
                    return@setOnItemSelectedListener true
                }
                R.id.item_bluetooth -> {
                    binding.viewPager.currentItem = 1
                    return@setOnItemSelectedListener true
                }
                R.id.item_notification -> {
                    binding.viewPager.currentItem = 2
                    return@setOnItemSelectedListener true
                }
                R.id.item_setting -> {
                    binding.viewPager.currentItem = 3
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }
}