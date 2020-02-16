package com.tfandkusu.dailycalendar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.days
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DailyCalendarViewModel(private val currentTimeGetter: CurrentTimeGetter) : ViewModel() {

    val days = MutableLiveData<List<DateTimeTz>>()

    fun onCreate() = viewModelScope.launch(Dispatchers.Main) {
        var startDay = currentTimeGetter.get()
        // Test flag for data set change
        val changeTest = false
        while (true) {
            var today = startDay
            val items = mutableListOf<DateTimeTz>()
            for (i in 0 until 10) {
                items.add(today)
                today += 1.days
            }
            days.value = items
            delay(3000)
            startDay += 1.days
            @Suppress("ConstantConditionIf")
            if (!changeTest)
                break
        }
    }
}