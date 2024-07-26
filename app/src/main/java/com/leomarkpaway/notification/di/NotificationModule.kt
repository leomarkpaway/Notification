package com.leomarkpaway.notification.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

interface NotificationModule {
    val builder: NotificationCompat.Builder
    val manager: NotificationManager?
}

class NotificationModuleImpl(
    private val appContext: Context,
    private val channelID: String,
    private val channelName: String
) : NotificationModule {

    override val builder: NotificationCompat.Builder =
        NotificationCompat.Builder(appContext, channelID)

    override val manager = createNotificationManager()

    private fun createNotificationManager() : NotificationManager? {
        val channel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        val manager = ContextCompat.getSystemService(appContext, NotificationManager::class.java)
        manager?.createNotificationChannel(channel)
        return manager
    }

}