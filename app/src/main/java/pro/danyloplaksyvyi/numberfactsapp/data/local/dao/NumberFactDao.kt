package pro.danyloplaksyvyi.numberfactsapp.data.local.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pro.danyloplaksyvyi.numberfactsapp.data.local.entity.NumberFactEntity

@Dao
interface NumberFactDao {
    @Query("SELECT * FROM number_facts ORDER BY timestamp DESC")
    fun getAllFacts(): Flow<List<NumberFactEntity>>

    @Insert
    suspend fun insertFact(fact: NumberFactEntity)

    @Query("SELECT * FROM number_facts WHERE id = :id")
    suspend fun getFactById(id: Long): NumberFactEntity?
}
