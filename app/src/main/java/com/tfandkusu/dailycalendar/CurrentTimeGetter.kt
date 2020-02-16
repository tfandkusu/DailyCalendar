package com.tfandkusu.dailycalendar

import com.soywiz.klock.DateTimeTz

/**
 * Get current time.
 * When unit testing, current time is fixed.
 */
interface CurrentTimeGetter {
    fun get(): DateTimeTz
}

class CurrentTimeGetterImpl : CurrentTimeGetter {
    override fun get(): DateTimeTz {
        return DateTimeTz.nowLocal()
    }
}