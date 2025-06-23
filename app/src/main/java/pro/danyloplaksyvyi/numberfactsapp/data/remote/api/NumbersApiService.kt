package pro.danyloplaksyvyi.numberfactsapp.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersApiService {
    @GET("{number}")
    suspend fun getNumberFact(@Path("number") number: String): Response<String>

    @GET("random/math")
    suspend fun getRandomMathFact(): Response<String>
}