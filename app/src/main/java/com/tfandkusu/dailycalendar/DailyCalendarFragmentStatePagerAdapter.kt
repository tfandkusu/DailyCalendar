package com.tfandkusu.dailycalendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.soywiz.klock.DateTimeTz

class DailyCalendarFragmentStatePagerAdapter(
    fragmentManager: FragmentManager,
    private val days: List<DateTimeTz>
) : FragmentStatePagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        val day = days[position]
        val fragment = DailyCalendarFragment()
        val bundle = Bundle()
        bundle.putLong(DailyCalendarFragment.EXTRA_DATE_TIME, day.local.unixMillisLong)
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return days.size
    }
}