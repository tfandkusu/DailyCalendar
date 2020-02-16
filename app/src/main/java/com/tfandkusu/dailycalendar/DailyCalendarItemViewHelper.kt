package com.tfandkusu.dailycalendar

import android.view.View
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.KlockLocale
import com.soywiz.klock.locale.japanese
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_daily_calendar.view.*

class DailyCalendarItemViewHelper(override val containerView: View) : LayoutContainer {
    fun bind(dateTime: DateTimeTz) {
        val itemView = containerView.rootView
        val context = itemView.context
        itemView.year.text =
            "%d%s".format(dateTime.year.year, context.getString(R.string.year))
        itemView.month.text = dateTime.month.localName(KlockLocale.japanese)
        itemView.day.text = dateTime.dayOfMonth.toString()
        itemView.dayOfWeek.text = dateTime.dayOfWeek.localName(KlockLocale.japanese)
        if (dateTime.dayOfWeek.index0 == 0) {
            itemView.dayOfWeek.setTextColor(context.resources.getColor(R.color.sunday))
        } else if (dateTime.dayOfWeek.index0 == 6) {
            itemView.dayOfWeek.setTextColor(context.resources.getColor(R.color.saturday))
        } else {
            itemView.dayOfWeek.setTextColor(context.resources.getColor(R.color.text))
        }
    }
}