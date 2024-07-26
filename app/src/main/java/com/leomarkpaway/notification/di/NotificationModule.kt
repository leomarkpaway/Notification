package com.leomarkpaway.notification.di

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.leomarkpaway.notification.R

interface NotificationModule {
    fun notificationManager(): NotificationManager?
    fun notification(title: String, message: String): Notification
}

class NotificationModuleImpl(
    private val appContext: Context,
    private val channelID: String,
    private val channelName: String
) : NotificationModule {

    override fun notificationManager(): NotificationManager? {
        val channel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        val manager = ContextCompat.getSystemService(appContext, NotificationManager::class.java)
        manager?.createNotificationChannel(channel)
        return manager
    }

    override fun notification(title: String, message: String): Notification {
        return NotificationCompat.Builder(appContext, channelID)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .build()
    }

}