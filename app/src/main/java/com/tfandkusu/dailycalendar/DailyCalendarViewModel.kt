package com.tfandkusu.dailycalendar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.days

class DailyCalendarViewModel(private val currentTimeGetter: CurrentTimeGetter) : ViewModel() {

    val days = MutableLiveData<List<DateTimeTz>>()

    fun onCreate() {
        var today = currentTimeGetter.get()
        val days = mutableListOf<DateTimeTz>()
        for (i in 0 until 10) {
            days.add(today)
            today += 1.days
        }
        this.days.value = days
    }
}