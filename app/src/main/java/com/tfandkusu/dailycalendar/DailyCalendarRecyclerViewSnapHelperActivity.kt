package com.tfandkusu.dailycalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_daily_calendar_recycler_view_snap_helper.*
import org.koin.android.viewmodel.ext.android.viewModel

class DailyCalendarRecyclerViewSnapHelperActivity : AppCompatActivity() {

    private val viewModel: DailyCalendarViewModel by viewModel()

    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_calendar_recycler_view_snap_helper)
        viewModel.days.observe(this, Observer { days ->
            days?.let {
                adapter.update(days.map { DailyCalendarItem(it) })
            }
        })
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = adapter
        viewModel.onCreate()
    }
}
