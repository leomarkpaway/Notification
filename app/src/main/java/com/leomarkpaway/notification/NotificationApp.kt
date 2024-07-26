package com.leomarkpaway.notification

import android.app.Application
import com.leomarkpaway.notification.di.AppModule
import com.leomarkpaway.notification.di.AppModuleImpl

class NotificationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }

    companion object {
        lateinit var appModule: AppModule
    }

}