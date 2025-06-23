package pro.danyloplaksyvyi.numberfactsapp.data.remote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiClient {
    private const val BASE_URL = "http://numbersapi.com"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val apiService: NumbersApiService by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).client(httpClient).addConverterFactory(ScalarsConverterFactory.create())
            .build().create(NumbersApiService::class.java)
    }
}