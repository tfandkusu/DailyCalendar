package com.tfandkusu.dailycalendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.soywiz.klock.DateTimeTz

class DailyCalendarFragmentStateAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    val days = mutableListOf<DateTimeTz>()

    override fun getItemCount(): Int {
        return days.size
    }

    override fun createFragment(position: Int): Fragment {
        val day = days[position]
        val fragment = DailyCalendarFragment()
        val bundle = Bundle()
        bundle.putLong(DailyCalendarFragment.EXTRA_DATE_TIME, day.local.unixMillisLong)
        fragment.arguments = bundle
        return fragment
    }
}