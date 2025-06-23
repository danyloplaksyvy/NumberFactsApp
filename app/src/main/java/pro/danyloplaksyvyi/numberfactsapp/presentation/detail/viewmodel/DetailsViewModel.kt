package pro.danyloplaksyvyi.numberfactsapp.presentation.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact
import pro.danyloplaksyvyi.numberfactsapp.domain.usecase.GetFactByIdUseCase
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getFactByIdUseCase: GetFactByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun loadFact(factId: Long) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            val fact = getFactByIdUseCase(factId)
            _uiState.value = _uiState.value.copy(
                fact = fact,
                isLoading = false
            )
        }
    }
}

data class DetailUiState(
    val fact: NumberFact? = null,
    val isLoading: Boolean = false
)