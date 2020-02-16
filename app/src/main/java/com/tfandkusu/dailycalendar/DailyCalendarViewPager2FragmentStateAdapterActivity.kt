package com.tfandkusu.dailycalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_daily_calendar_view_pager2_fragment_state_adapter.*
import org.koin.android.viewmodel.ext.android.viewModel

class DailyCalendarViewPager2FragmentStateAdapterActivity : AppCompatActivity() {
    private val viewModel: DailyCalendarViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_calendar_view_pager2_fragment_state_adapter)

        viewModel.days.observe(this, Observer { days ->
            days?.let {
                val fragmentStateAdapter = DailyCalendarFragmentStateAdapter(this, it)
                viewPager.adapter = fragmentStateAdapter
            }
        })

        viewModel.onCreate()
    }
}
