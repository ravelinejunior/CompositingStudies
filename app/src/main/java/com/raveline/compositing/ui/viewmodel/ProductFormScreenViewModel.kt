package com.raveline.compositing.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.raveline.compositing.ui.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ProductFormScreenViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<ProductFormUiState> = MutableStateFlow(
        ProductFormUiState()
    )
    val uiState: StateFlow<ProductFormUiState> get() = _uiState

    init {

        _uiState.update { currentState ->
            currentState.copy(
                onUrlChange = {
                    _uiState.value = _uiState.value.copy(
                        // Update products using the values passed by functions
                        url = it,
                    )
                },
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        // Update products using the values passed by functions
                        name = it,
                    )
                },
                onDescriptionChange = {
                    _uiState.value = _uiState.value.copy(
                        // Update products using the values passed by functions
                        description = it,
                    )
                },
                onPriceChange = {
                    _uiState.value = _uiState.value.copy(
                        // Update products using the values passed by functions
                        price = it,
                    )
                },
                onSuccessClick = {

                },

            )
        }
    }

}