package pro.danyloplaksyvyi.numberfactsapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pro.danyloplaksyvyi.numberfactsapp.data.local.dao.NumberFactDao
import pro.danyloplaksyvyi.numberfactsapp.data.local.entity.NumberFactEntity

@Database(
    entities = [NumberFactEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NumberFactDatabase : RoomDatabase() {
    abstract fun numberFactDao(): NumberFactDao

    companion object {
        @Volatile
        private var INSTANCE: NumberFactDatabase? = null

        fun getDatabase(context: Context): NumberFactDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NumberFactDatabase::class.java,
                    "number_fact_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
