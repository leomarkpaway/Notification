package com.leomarkpaway.notification.common.utils

import android.content.Context
import android.widget.Toast


fun Context.showToastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
