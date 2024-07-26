package com.leomarkpaway.notification.view

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.leomarkpaway.notification.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)

        val channelID = "MyChannelID"
        val channelName = "MyChannelName"
        createChannel(channelID, channelName)

        val notificationId = 0
        button.setOnClickListener {
            createNotification(channelID, notificationId, "My title", "My content")
        }

    }
}

fun Context.createChannel(channelID: String, channelName: String) {
    val channel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT)
    val manager = ContextCompat.getSystemService(this, NotificationManager::class.java)
    manager?.createNotificationChannel(channel)
}

fun Context.createNotification(channelID: String, notificationId: Int,title: String, content: String) {
    val notification = NotificationCompat.Builder(this, channelID)
        .setContentTitle(title)
        .setContentText(content)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setAutoCancel(true)
        .build()

    val manager = ContextCompat.getSystemService(this, NotificationManager::class.java)
    manager?.notify(notificationId, notification)
}