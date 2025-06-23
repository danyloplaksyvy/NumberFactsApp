package pro.danyloplaksyvyi.numberfactsapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact
import pro.danyloplaksyvyi.numberfactsapp.domain.repository.NumberFactRepository
import javax.inject.Inject

class GetAllFactsUseCase @Inject constructor(
    private val repository: NumberFactRepository
) {
    operator fun invoke(): Flow<List<NumberFact>> {
        return repository.getAllFacts()
    }
}