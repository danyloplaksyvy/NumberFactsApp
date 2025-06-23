package pro.danyloplaksyvyi.numberfactsapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number_facts")
data class NumberFactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val number: String,
    val fact: String,
    val timestamp: Long = System.currentTimeMillis(),
    val isRandom: Boolean = false
)
