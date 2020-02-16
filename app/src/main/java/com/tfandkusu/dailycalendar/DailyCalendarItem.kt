package com.tfandkusu.dailycalendar

import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.KlockLocale
import com.soywiz.klock.locale.japanese
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_daily_calendar.view.*


class DailyCalendarItem(private val dateTime: DateTimeTz) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val context = viewHolder.itemView.context
        viewHolder.itemView.year.text =
            "%d%s".format(dateTime.year.year, context.getString(R.string.year))
        viewHolder.itemView.month.text = dateTime.month.localName(KlockLocale.japanese)
        viewHolder.itemView.day.text = dateTime.dayOfMonth.toString()
        viewHolder.itemView.dayOfWeek.text = dateTime.dayOfWeek.localName(KlockLocale.japanese)
        if (dateTime.dayOfWeek.index0 == 0) {
            viewHolder.itemView.dayOfWeek.setTextColor(context.resources.getColor(R.color.sunday))
        } else if (dateTime.dayOfWeek.index0 == 6) {
            viewHolder.itemView.dayOfWeek.setTextColor(context.resources.getColor(R.color.saturday))
        } else {
            viewHolder.itemView.dayOfWeek.setTextColor(context.resources.getColor(R.color.text))
        }
    }

    override fun getLayout() = R.layout.list_item_daily_calendar

}