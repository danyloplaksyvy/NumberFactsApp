package pro.danyloplaksyvyi.numberfactsapp.domain.usecase

import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact
import pro.danyloplaksyvyi.numberfactsapp.domain.repository.NumberFactRepository
import javax.inject.Inject

class GetNumberFactUseCase @Inject constructor(
    private val repository: NumberFactRepository
) {
    suspend operator fun invoke(number: String): Result<NumberFact> {
        return repository.getNumberFact(number)
    }
}