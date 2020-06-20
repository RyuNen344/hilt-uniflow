package com.ryunen344.hilt.uniflow

import android.app.Application
import timber.log.LogcatTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(LogcatTree())
    }
}
