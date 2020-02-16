package com.tfandkusu.dailycalendar

import com.soywiz.klock.DateTimeTz
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item


class DailyCalendarItem(private val dateTime: DateTimeTz) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val viewHelper = DailyCalendarItemViewHelper(viewHolder.itemView)
        viewHelper.bind(dateTime)
    }

    override fun getLayout() = R.layout.list_item_daily_calendar

}