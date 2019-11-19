package vn.sunasterisk.realfootball.di

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.sunasterisk.realfootball.FootballApplication
import vn.sunasterisk.realfootball.data.remote.NetworkInterceptor
import vn.sunasterisk.realfootball.data.remote.ResponseInterceptor
import vn.sunasterisk.realfootball.utils.LiveDataCallAdapterFactory
import java.util.concurrent.TimeUnit

object RemoteProperties {
    const val TIME_OUT = 10L
    const val BaseUrl = "https://www.thesportsdb.com/api/v1/json/1/"
}

fun createBaseUrl() = RemoteProperties.BaseUrl

inline fun <reified T> createWebService(
    baseUrl: String,
    gsonConverterFactory: GsonConverterFactory,
    liveDataCallAdapterFactory: LiveDataCallAdapterFactory,
    client: OkHttpClient
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(liveDataCallAdapterFactory)
        .client(client)
        .build()
    return retrofit.create(T::class.java)
}

private fun createOkHttpClient(): OkHttpClient {
    val cacheSize = (5 * 1024 * 1024).toLong()
    val cache = Cache(FootballApplication.applicationContext?.cacheDir, cacheSize)

    val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val builder = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(NetworkInterceptor())
        .addInterceptor(ResponseInterceptor())
        .connectTimeout(RemoteProperties.TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(RemoteProperties.TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(RemoteProperties.TIME_OUT, TimeUnit.SECONDS)
    return builder.build()
}

val remoteModule = module {
    single { createBaseUrl() }
    single { NetworkInterceptor() }
    single { ResponseInterceptor() }
    single { GsonConverterFactory.create() }
    single { LiveDataCallAdapterFactory() }
    single { createOkHttpClient() }
    single(named(RemoteProperties::class.java.name)) {
        createWebService<FootballService>(get(), get(), get(), get())
    }
}
