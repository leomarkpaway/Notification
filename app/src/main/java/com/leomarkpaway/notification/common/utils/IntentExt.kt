package com.leomarkpaway.notification.common.utils

import android.app.Activity
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

inline fun <reified T : Activity> Context.intentActivity(): Intent = Intent(this, T::class.java)
inline fun <reified T : Activity> Context.pendingIntentActivity(
    requestCode: Int,
    flag: Int,
    apply: (Intent) -> Unit
): PendingIntent {
    val intentActivity = Intent(this, T::class.java).apply(apply)
    return PendingIntent.getActivity(this, requestCode, intentActivity, flag)
}