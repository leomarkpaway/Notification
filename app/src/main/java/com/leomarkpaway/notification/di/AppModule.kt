package com.leomarkpaway.notification.di

import android.content.Context


interface AppModule {
    val notification: NotificationModule
}

class AppModuleImpl(appContext: Context) : AppModule {
    override val notification: NotificationModule =
        NotificationModuleImpl(appContext, "MyChannelID", "MyChannelName")
}