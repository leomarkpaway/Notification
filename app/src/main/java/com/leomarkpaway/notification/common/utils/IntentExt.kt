package com.leomarkpaway.notification.common.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T : Activity> Context.intentActivity(): Intent = Intent(this, T::class.java)