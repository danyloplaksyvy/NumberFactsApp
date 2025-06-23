package pro.danyloplaksyvyi.numberfactsapp.domain.usecase

import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact
import pro.danyloplaksyvyi.numberfactsapp.domain.repository.NumberFactRepository
import javax.inject.Inject

class GetFactByIdUseCase @Inject constructor(
    private val repository: NumberFactRepository
) {
    suspend operator fun invoke(id: Long): NumberFact? {
        return repository.getFactById(id)
    }
}