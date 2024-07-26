package com.leomarkpaway.notification.view

import android.app.PendingIntent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.leomarkpaway.notification.NotificationApp
import com.leomarkpaway.notification.R
import com.leomarkpaway.notification.common.utils.pendingIntentActivity
import com.leomarkpaway.notification.databinding.ActivityMainBinding
import com.leomarkpaway.notification.viewmodel.MainViewModel
import com.leomarkpaway.notification.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            viewModelStore,
            MainViewModelFactory(NotificationApp.appModule.notification)
        )[MainViewModel::class.java]

        binding.btnNotification.setOnClickListener {
            val title = "simple notification"
           viewModel.showSimpleNotification(0, title)
        }

        binding.btnNotifWithIntentActivity.setOnClickListener {
            val title = "notification with action"
            val actionName = "Open Activity"
            val pendingIntent =
                pendingIntentActivity<MainActivity>(0, PendingIntent.FLAG_IMMUTABLE, {})
            viewModel.showNotificationWithAction(1, title, pendingIntent, actionName)
        }

    }
}