package pro.danyloplaksyvyi.numberfactsapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pro.danyloplaksyvyi.numberfactsapp.data.local.dao.NumberFactDao
import pro.danyloplaksyvyi.numberfactsapp.data.local.database.NumberFactDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNumberFactDatabase(@ApplicationContext context: Context): NumberFactDatabase {
        return NumberFactDatabase.getDatabase(context)
    }

    @Provides
    fun provideNumberFactDao(database: NumberFactDatabase): NumberFactDao {
        return database.numberFactDao()
    }
}