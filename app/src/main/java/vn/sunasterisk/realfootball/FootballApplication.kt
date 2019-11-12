package vn.sunasterisk.realfootball

import android.app.Application
import android.content.Context

class FootballApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: FootballApplication
            private set
        val applicationContext: Context?
            get() = if (::INSTANCE.isInitialized) INSTANCE.applicationContext else null
    }
}
