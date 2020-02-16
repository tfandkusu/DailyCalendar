package com.tfandkusu.dailycalendar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2RecyclerViewAdapterButton.setOnClickListener {
            val intent =
                Intent(this, DailyCalendarViewPager2RecyclerViewAdapterActivity::class.java)
            startActivity(intent)
        }
        viewPager2FragmentStateAdapterButton.setOnClickListener {
            val intent =
                Intent(this, DailyCalendarViewPager2FragmentStateAdapterActivity::class.java)
            startActivity(intent)
        }
    }
}
