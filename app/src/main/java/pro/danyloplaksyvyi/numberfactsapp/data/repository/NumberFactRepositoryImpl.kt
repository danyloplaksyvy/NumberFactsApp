package pro.danyloplaksyvyi.numberfactsapp.data.repository

import kotlinx.coroutines.flow.Flow
import pro.danyloplaksyvyi.numberfactsapp.data.remote.api.NumbersApiService
import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact
import pro.danyloplaksyvyi.numberfactsapp.domain.repository.NumberFactRepository
import javax.inject.Inject

class NumberFactRepositoryImpl @Inject constructor(
    private val apiService: NumbersApiService,
) : NumberFactRepository {
    override fun getAllFacts(): Flow<List<NumberFact>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFactById(id: Long): NumberFact? {
        TODO("Not yet implemented")
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