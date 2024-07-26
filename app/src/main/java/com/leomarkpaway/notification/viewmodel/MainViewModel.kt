package com.leomarkpaway.notification.viewmodel

import android.app.PendingIntent
import androidx.lifecycle.ViewModel
import com.leomarkpaway.notification.R
import com.leomarkpaway.notification.di.NotificationModule

class MainViewModel(private val notification: NotificationModule) : ViewModel() {

    fun showSimpleNotification(id: Int, title: String) {
        val simpleNotification =
            notification.builder.setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
        notification.manager?.notify(id, simpleNotification.build())
    }

    fun showNotificationWithAction(
        id: Int,
        title: String,
        pendingIntent: PendingIntent,
        actionName: String
    ) {
        val notificationWithAction = notification.builder
            .setContentTitle(title)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .addAction(0, actionName, pendingIntent)
            .build()
        notification.manager?.notify(id, notificationWithAction)
    }

}