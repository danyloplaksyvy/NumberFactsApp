package pro.danyloplaksyvyi.numberfactsapp.domain.repository

import kotlinx.coroutines.flow.Flow
import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact

interface NumberFactRepository {
    fun getAllFacts(): Flow<List<NumberFact>> // Local
    suspend fun getFactById(id: Long): NumberFact? // Local
    suspend fun getNumberFact(number: String): Result<NumberFact> // Remote
    suspend fun getRandomFact(): Result<NumberFact> // Remote
}
