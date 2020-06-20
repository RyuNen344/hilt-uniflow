package com.ryunen344.hilt.uniflow

import android.app.Application
import com.ryunen344.hilt.uniflow.api.apiModule
import com.ryunen344.hilt.uniflow.home.homeModule
import com.ryunen344.hilt.uniflow.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.LogcatTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            androidFileProperties()
            fragmentFactory()
            modules(apiModule, repositoryModule, homeModule)
        }

        Timber.plant(LogcatTree())
    }
}
