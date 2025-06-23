package pro.danyloplaksyvyi.numberfactsapp.presentation.main.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pro.danyloplaksyvyi.numberfactsapp.domain.model.NumberFact
import pro.danyloplaksyvyi.numberfactsapp.domain.usecase.GetAllFactsUseCase
import pro.danyloplaksyvyi.numberfactsapp.domain.usecase.GetNumberFactUseCase
import pro.danyloplaksyvyi.numberfactsapp.domain.usecase.GetRandomFactUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNumberFactUseCase: GetNumberFactUseCase,
    private val getRandomFactUseCase: GetRandomFactUseCase,
    private val getAllFactsUseCase: GetAllFactsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        loadFacts()
    }

    fun onNumberChanged(number: String) {
        _uiState.value = _uiState.value.copy(inputNumber = number)
    }

    fun getNumberFact() {
        val number = _uiState.value.inputNumber.trim()
        if (number.isEmpty() || !number.matches(Regex("\\d+"))) {
            _uiState.value = _uiState.value.copy(
                error = "Please enter a valid number"
            )
            return
        }

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            getNumberFactUseCase(number).fold(
                onSuccess = {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        inputNumber = ""
                    )
                },
                onFailure = { error ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = error.message ?: "Unknown error occurred"
                    )
                }
            )
        }
    }

    fun getRandomFact() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            getRandomFactUseCase().fold(
                onSuccess = {
                    _uiState.value = _uiState.value.copy(isLoading = false)
                },
                onFailure = { error ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = error.message ?: "Unknown error occurred"
                    )
                }
            )
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    private fun loadFacts() {
        viewModelScope.launch {
            getAllFactsUseCase().collect { facts ->
                _uiState.value = _uiState.value.copy(facts = facts)
            }
        }
    }
}

data class MainUiState(
    val inputNumber: String = "",
    val facts: List<NumberFact> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)