package com.leomarkpaway.notification.di

import android.content.Context


interface AppModule {}

class AppModuleImpl(appContext: Context) : AppModule {}