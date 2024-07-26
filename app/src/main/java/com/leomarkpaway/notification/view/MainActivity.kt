package com.leomarkpaway.notification.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leomarkpaway.notification.NotificationApp
import com.leomarkpaway.notification.R
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
        val notificationManager = NotificationApp.appModule.notification.notificationManager()
        val notification = NotificationApp.appModule.notification.notification(title, message)
        binding.btnNotification.setOnClickListener {
            notificationManager?.notify(notificationId, notification)
        }

    }
}