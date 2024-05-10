package net.yuuzu.econotracker

import android.app.Application
import di.KoinInitializer

class EconoTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}