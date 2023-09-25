package com.raveline.compositing.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.raveline.compositing.dao.ProductsDao
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.ui.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal

class ProductFormScreenViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<ProductFormUiState> = MutableStateFlow(
        ProductFormUiState()
    )
    val uiState: StateFlow<ProductFormUiState> get() = _uiState

    private val dao = ProductsDao()

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

    fun saveData(
        uiState: ProductFormUiState,
    ) {
        val convertedPrice = try {
            BigDecimal(uiState.price)
        } catch (e: NumberFormatException) {
            BigDecimal.ZERO
        }

        if (validateFields(
                uiState.name,
                uiState.description,
                convertedPrice,
            )
        ) {

            val product: ProductItemModel = if (uiState.url.isNotBlank()) {
                ProductItemModel(
                    name = uiState.name.trim(),
                    description = uiState.description.trim(),
                    price = convertedPrice,
                    image = uiState.url.trim()
                )
            } else {
                ProductItemModel(
                    name = uiState.name.trim(),
                    description = uiState.description.trim(),
                    price = convertedPrice,
                )
            }

            dao.saveProduct(product)

        }
    }

    private fun validateFields(
        name: String,
        description: String,
        price: BigDecimal,
    ): Boolean {
        return name.isNotBlank() &&
                description.isNotBlank() &&
                price > BigDecimal.ZERO
    }


}