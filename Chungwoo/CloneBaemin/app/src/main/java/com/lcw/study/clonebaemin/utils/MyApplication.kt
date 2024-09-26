package com.lcw.study.clonebaemin.utils

import android.app.Application
import com.lcw.study.clonebaemin.data.local.PreferenceUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {
    companion object{
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
    }
}