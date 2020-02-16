package com.tfandkusu.dailycalendar

import com.soywiz.klock.DateTimeTz
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_days.view.*

class DaysItem(private val days: List<DateTimeTz>) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val adapter = GroupAdapter<com.xwray.groupie.GroupieViewHolder>()
        adapter.update(days.map { DailyCalendarItem(it) })
        viewHolder.itemView.viewPager.adapter = adapter
    }

    override fun getLayout() = R.layout.list_item_days
}