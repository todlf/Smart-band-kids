package com.example.smart_band_kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    private var sensorData: Map<String, Float?> = emptyMap()

    companion object {
        fun newInstance(sensorData: Map<String, Float?>): HomeFragment {
            val fragment = HomeFragment()
            fragment.arguments = Bundle().apply {
                putFloat("water", sensorData["water"] ?: Float.NaN)
                putFloat("accelX", sensorData["accelX"] ?: Float.NaN)
                putFloat("accelY", sensorData["accelY"] ?: Float.NaN)
                putFloat("accelZ", sensorData["accelZ"] ?: Float.NaN)
            }
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sensorData = mapOf(
                "water" to it.getFloat("water"),
                "accelX" to it.getFloat("accelX"),
                "accelY" to it.getFloat("accelY"),
                "accelZ" to it.getFloat("accelZ")
            )
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
    }

    private fun updateUI() {
        view?.findViewById<TextView>(R.id.tvWaterStatus)?.text = "Water Level: ${sensorData["water"]}"
        view?.findViewById<TextView>(R.id.tvFallStatus)?.text = "Accel X: ${sensorData["accelX"]}, " +
                "Y: ${sensorData["accelY"]}, Z: ${sensorData["accelZ"]}"
    }
}