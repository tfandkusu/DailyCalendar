package com.tfandkusu.dailycalendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.soywiz.klock.DateTimeTz
import java.util.*

class DailyCalendarFragment : Fragment() {
    companion object {
        const val EXTRA_DATE_TIME = "dateTime"

        private const val EXTRA_UUID = "uuid"
    }

    private lateinit var dateTimeTz: DateTimeTz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.let {
            val uuid = it.getString(EXTRA_UUID)
            Log.d("DailyCalendar", "load %s".format(uuid))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_item_daily_calendar, container, false)
        val dateTimeLong = arguments?.getLong(EXTRA_DATE_TIME, 0L) ?: 0L
        dateTimeTz = DateTimeTz.fromUnixLocal(dateTimeLong)
        val viewHelper = DailyCalendarItemViewHelper(view)
        viewHelper.bind(dateTimeTz)
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val uuid = UUID.randomUUID().toString()
        outState.putString(EXTRA_UUID, uuid)
        Log.d("DailyCalendar", "save %s %s".format(dateTimeTz.toString(), uuid))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DailyCalendar", "onDestroy %s".format(dateTimeTz.toString()))
    }
}