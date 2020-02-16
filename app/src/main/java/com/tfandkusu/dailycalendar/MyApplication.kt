package com.tfandkusu.dailycalendar

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val myModule = module {
            single { CurrentTimeGetterImpl() as CurrentTimeGetter }
            viewModel { DailyCalendarViewModel(get()) }
        }
        startKoin {
            androidContext(this@MyApplication)
            modules(myModule)
        }
    }
}