package com.tfandkusu.dailycalendar

import com.soywiz.klock.DateTimeTz
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item_time.view.*

class TimeItem : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val now = DateTimeTz.nowLocal()
        viewHolder.itemView.time.text = now.format("HH:mm:ss")
    }

    override fun getLayout() = R.layout.list_item_time

}