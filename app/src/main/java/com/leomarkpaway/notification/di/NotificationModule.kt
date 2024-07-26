package com.leomarkpaway.notification.di

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.leomarkpaway.notification.R

interface NotificationModule {
    val notificationBuilder: NotificationCompat.Builder
    fun notificationManager(): NotificationManager?
    fun notification(title: String, message: String): Notification
    fun notificationWithIntentActivity(
        title: String,
        message: String,
        intent: Intent,
        actionName: String
    ): Notification
}

class NotificationModuleImpl(
    private val appContext: Context,
    private val channelID: String,
    private val channelName: String
) : NotificationModule {

    override val notificationBuilder: NotificationCompat.Builder =
        NotificationCompat.Builder(appContext, channelID)

    override fun notificationManager(): NotificationManager? {
        val channel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        val manager = ContextCompat.getSystemService(appContext, NotificationManager::class.java)
        manager?.createNotificationChannel(channel)
        return manager
    }

    override fun notification(title: String, message: String): Notification {
        return notificationBuilder.setContentTitle(title).setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher).build()
    }

    override fun notificationWithIntentActivity(
        title: String,
        message: String,
        intent: Intent,
        actionName: String
    ): Notification {
        val pendingIntent = PendingIntent.getActivity(appContext, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        return notificationBuilder
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .addAction(0, actionName, pendingIntent)
            .build()
    }

}