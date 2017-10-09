package tech.thdev.kotlin_udemy_sample.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by tae-hwan on 11/7/16.
 */

fun <T> createRetrofit(cls: Class<T>, baseUrl: String): T {
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient())
            .build()

    return retrofit.create(cls)
}

/**
 * OkHttp에 HttpLoggingInterceptor을 추가하여 Log을 출력한다
 * <a href="http://square.github.io/okhttp/">OkHttp</a>
 * <a href="https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor">Okhttp</a>
 */
private fun createOkHttpClient(): OkHttpClient {
    val builder: OkHttpClient.Builder = OkHttpClient.Builder()

    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    builder.addInterceptor(interceptor)
    return builder.build()
}