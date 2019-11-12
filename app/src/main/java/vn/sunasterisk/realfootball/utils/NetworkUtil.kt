package vn.sunasterisk.realfootball.utils

import android.content.Context
import android.net.ConnectivityManager
import vn.sunasterisk.realfootball.FootballApplication

object NetworkUtil {
    fun isNetworkAvailable(): Boolean {
        val manager =
            FootballApplication.applicationContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return manager.activeNetworkInfo?.isConnected ?: false
    }
}
