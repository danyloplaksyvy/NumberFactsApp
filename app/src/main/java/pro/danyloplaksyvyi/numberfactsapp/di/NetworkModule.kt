package pro.danyloplaksyvyi.numberfactsapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.danyloplaksyvyi.numberfactsapp.data.remote.api.ApiClient
import pro.danyloplaksyvyi.numberfactsapp.data.remote.api.NumbersApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNumbersApiService(): NumbersApiService {
        return ApiClient.apiService
    }
}
