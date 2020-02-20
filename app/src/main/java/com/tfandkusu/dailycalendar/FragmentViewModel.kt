package com.tfandkusu.dailycalendar

import android.util.Log
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {

    init {
        Log.d("DailyCalendar", "FragmentViewModel#init")
    }

    var dateString = ""

    override fun onCleared() {
        super.onCleared()
        Log.d("DailyCalendar", "FragmentViewModel#onCleared $dateString")
    }
}