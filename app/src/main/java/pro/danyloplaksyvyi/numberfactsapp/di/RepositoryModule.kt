package pro.danyloplaksyvyi.numberfactsapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.danyloplaksyvyi.numberfactsapp.data.repository.NumberFactRepositoryImpl
import pro.danyloplaksyvyi.numberfactsapp.domain.repository.NumberFactRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNumberFactRepository(
        numberFactRepositoryImpl: NumberFactRepositoryImpl
    ): NumberFactRepository
}
