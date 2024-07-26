package com.leomarkpaway.notification.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leomarkpaway.notification.NotificationApp
import com.leomarkpaway.notification.R
import com.leomarkpaway.notification.common.utils.intentActivity
import com.leomarkpaway.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val notificationId = 0
        val title = "My title"
        val message = "My message"
        val notificationModule = NotificationApp.appModule.notification
        val manager = notificationModule.notificationManager()

        binding.btnNotification.setOnClickListener {
            val notification = notificationModule.notification(title, message)
            manager?.notify(notificationId, notification)
        }

        binding.btnNotifWithIntentActivity.setOnClickListener {
            val intentMain = intentActivity<MainActivity>()
            val notification = notificationModule.notificationWithIntentActivity(
                title,
                message,
                intentMain,
                "Open Activity"
            )
            manager?.notify(notificationId, notification)
        }

    }
}