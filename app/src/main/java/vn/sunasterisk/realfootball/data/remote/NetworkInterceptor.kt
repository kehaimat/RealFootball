package vn.sunasterisk.realfootball.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import vn.sunasterisk.realfootball.FootballApplication
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.exceptions.NetworkException
import vn.sunasterisk.realfootball.utils.NetworkUtil

class NetworkInterceptor : Interceptor {

    @Throws(NetworkException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtil.isNetworkAvailable()) {
            FootballApplication.applicationContext?.let {
                throw NetworkException(it.getString(R.string.error_connect))
            }
        }
        return chain.proceed(chain.request())
    }
}
