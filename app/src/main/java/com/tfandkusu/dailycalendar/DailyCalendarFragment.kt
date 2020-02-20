package com.tfandkusu.dailycalendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.soywiz.klock.DateTimeTz

class DailyCalendarFragment : Fragment() {
    companion object {
        const val EXTRA_DATE_TIME = "dateTime"

        private const val EXTRA_STRING = "string"
    }

    private lateinit var viewModel: FragmentViewModel

    private lateinit var dateTimeTz: DateTimeTz

    private var dateString = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FragmentViewModel::class.java)

        savedInstanceState?.let {
            dateString = it.getString(EXTRA_STRING, "")
            Log.d("DailyCalendar", "load %s".format(dateString))
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
        dateString = dateTimeTz.toString("YYYY/MM/dd")
        viewModel.dateString = dateString
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(EXTRA_STRING, dateString)
        Log.d("DailyCalendar", "save %s".format(dateString))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DailyCalendar", "onDestroy %s".format(dateString))
    }
}