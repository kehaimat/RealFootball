package vn.sunasterisk.realfootball

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import vn.sunasterisk.realfootball.di.remoteModule
import vn.sunasterisk.realfootball.di.sourceModule
import vn.sunasterisk.realfootball.di.viewModelModule

class FootballApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidLogger()
            androidContext(this@FootballApplication)
            modules(listOf(remoteModule, sourceModule, viewModelModule))
        }
    }

    companion object {
        lateinit var INSTANCE: FootballApplication
            private set
        val applicationContext: Context?
            get() = if (::INSTANCE.isInitialized) INSTANCE.applicationContext else null
    }
}
