package com.tfandkusu.dailycalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_daily_calendar_view_pager2_recycler_view_adapter.*
import org.koin.android.viewmodel.ext.android.viewModel

class DailyCalendarViewPager2RecyclerViewAdapterActivity : AppCompatActivity() {

    private val viewModel: DailyCalendarViewModel by viewModel()

    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_calendar_view_pager2_recycler_view_adapter)
        viewModel.days.observe(this, Observer { days ->
            days?.let {
                adapter.update(it.map { day ->
                    DailyCalendarItem(day)
                })
            }
        })
        viewPager.adapter = adapter
        viewModel.onCreate()
    }
}
