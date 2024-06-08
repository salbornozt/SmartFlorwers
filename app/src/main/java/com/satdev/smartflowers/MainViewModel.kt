package com.satdev.smartflowers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState.Loading)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        initialize()
    }

    fun initialize() = viewModelScope.launch {
        delay(3500)
        _uiState.value = MainUiState.Success
    }
}

sealed class MainUiState {
    data object Loading : MainUiState()
    data object Success : MainUiState()
}