package com.raveline.compositing.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raveline.compositing.dao.ProductsDao
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.model.sampleCandies
import com.raveline.compositing.model.sampleDrinks
import com.raveline.compositing.model.sampleProducts
import com.raveline.compositing.model.sampleSections
import com.raveline.compositing.model.sampleWomen
import com.raveline.compositing.ui.states.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val productsDao = ProductsDao()

    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )

    val uiState get() = _uiState.asStateFlow()

    private fun containsInNameOrDescription(
        text: String
    ) = { productItemModel: ProductItemModel ->
        (productItemModel.name.contains(text, true) ||
                productItemModel.description?.contains(text, true) == true)
    }

    private fun searchedProducts(text: String): List<ProductItemModel> =
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription(text)) +
                    productsDao.productsList().value.filter(containsInNameOrDescription(text))
        } else {
            emptyList()
        }

    init {

        _uiState.update { currentState ->
            currentState.copy(
                onSearchChange = {
                    _uiState.value = _uiState.value.copy(
                        // Update products using the values passed by functions
                        inputText = it,
                        searchedProducts = searchedProducts(it)
                    )
                }
            )
        }

        // When the value of text change, the state of home screen will also change
        viewModelScope.launch {
            productsDao.productsList().collect { products ->
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "All Products" to products + sampleProducts,
                        "Sales" to sampleDrinks + sampleCandies + sampleWomen,
                        "Candies" to sampleCandies,
                        "Drinks" to sampleDrinks,
                        "Women" to sampleWomen,
                    ),
                    searchedProducts = searchedProducts(_uiState.value.inputText),
                )
            }
        }
    }

}