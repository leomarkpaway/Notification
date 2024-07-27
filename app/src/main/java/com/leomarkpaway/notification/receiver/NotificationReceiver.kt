package com.leomarkpaway.notification.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.leomarkpaway.notification.common.enums.NotificationAction
import com.leomarkpaway.notification.common.utils.showToastLong

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        when (action) {
            NotificationAction.Open.id -> {
                context.showToastLong("On Receive $action")
            }
        }
    }
}