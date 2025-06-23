package pro.danyloplaksyvyi.numberfactsapp.domain.usecase

import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact
import pro.danyloplaksyvyi.numberfactsapp.domain.repository.NumberFactRepository
import javax.inject.Inject

class GetRandomFactUseCase @Inject constructor(
    private val repository: NumberFactRepository
) {
    suspend operator fun invoke(): Result<NumberFact> {
        return repository.getRandomFact()
    }
}