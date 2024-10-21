package com.example.smart_band_kids

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _waterSensorValue = MutableLiveData<Int>()
    val waterSensorValue: LiveData<Int> get() = _waterSensorValue

    private val _fallSensorValue = MutableLiveData<Int>()
    val fallSensorValue: LiveData<Int> get() = _fallSensorValue

    // 데이터를 업데이트하는 함수
    fun updateWaterSensorValue(value: Int) {
        _waterSensorValue.value = value
    }

    fun updateFallSensorValue(value: Int) {
        _fallSensorValue.value = value
    }
}