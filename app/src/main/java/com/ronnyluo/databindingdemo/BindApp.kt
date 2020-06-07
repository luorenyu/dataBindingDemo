package com.ronnyluo.databindingdemo

import android.app.Application

class BindApp : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: Application
    }
}