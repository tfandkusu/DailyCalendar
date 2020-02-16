package com.tfandkusu.dailycalendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.soywiz.klock.DateTimeTz

class DailyCalendarFragment : Fragment() {
    companion object {
        const val EXTRA_DATE_TIME = "dateTime"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_item_daily_calendar, container)
        val dateTimeLong = arguments?.getLong(EXTRA_DATE_TIME, 0L) ?: 0L
        val dateTimeTz = DateTimeTz.fromUnixLocal(dateTimeLong)
        val viewHelper = DailyCalendarItemViewHelper(view)
        viewHelper.bind(dateTimeTz)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        val dateTimeLong = arguments?.getLong(EXTRA_DATE_TIME, 0L) ?: 0L
        val dateTimeTz = DateTimeTz.fromUnixLocal(dateTimeLong)

        Log.d("DailyCalendar", "onDestroy %s".format(dateTimeTz.toString()))
    }
}