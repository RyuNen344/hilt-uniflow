package com.ryunen344.hilt.uniflow

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.LogcatTree
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(LogcatTree())
    }
}
