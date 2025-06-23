package pro.danyloplaksyvyi.numberfactsapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pro.danyloplaksyvyi.numberfactsapp.data.local.dao.NumberFactDao
import pro.danyloplaksyvyi.numberfactsapp.data.local.entity.NumberFactEntity
import pro.danyloplaksyvyi.numberfactsapp.data.remote.api.NumbersApiService
import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact
import pro.danyloplaksyvyi.numberfactsapp.domain.repository.NumberFactRepository
import javax.inject.Inject

class NumberFactRepositoryImpl @Inject constructor(
    private val apiService: NumbersApiService,
    private val dao: NumberFactDao
) : NumberFactRepository {

    override fun getAllFacts(): Flow<List<NumberFact>> {
        return dao.getAllFacts().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    override suspend fun getFactById(id: Long): NumberFact? {
        return dao.getFactById(id)?.toDomainModel()
    }

    override suspend fun getNumberFact(number: String): Result<NumberFact> {
        return try {
            val response = apiService.getNumberFact(number)
            if (response.isSuccessful && response.body() != null) {
                val fact = NumberFact(
                    number = number,
                    fact = response.body()!!,
                    isRandom = false
                )
                dao.insertFact(fact.toEntity())
                Result.success(fact)
            } else {
                Result.failure(Exception("Failed to fetch fact"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getRandomFact(): Result<NumberFact> {
        return try {
            val response = apiService.getRandomMathFact()
            if (response.isSuccessful && response.body() != null) {
                val factText = response.body()!!
                val number = extractNumberFromFact(factText)
                val fact = NumberFact(
                    number = number,
                    fact = factText,
                    isRandom = true
                )
                dao.insertFact(fact.toEntity())
                Result.success(fact)
            } else {
                Result.failure(Exception("Failed to fetch random fact"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun extractNumberFromFact(fact: String): String {
        return fact.split(" ").firstOrNull { it.matches(Regex("\\d+")) } ?: "Random"
    }
}

private fun NumberFactEntity.toDomainModel(): NumberFact {
    return NumberFact(
        id = id,
        number = number,
        fact = fact,
        timestamp = timestamp,
        isRandom = isRandom
    )
}

private fun NumberFact.toEntity(): NumberFactEntity {
    return NumberFactEntity(
        id = if (id == 0L) 0 else id,
        number = number,
        fact = fact,
        timestamp = timestamp,
        isRandom = isRandom
    )
}