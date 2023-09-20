package com.raveline.compositing.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.raveline.compositing.dao.ProductsDao
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.model.sampleCandies
import com.raveline.compositing.model.sampleDrinks
import com.raveline.compositing.model.sampleProducts
import com.raveline.compositing.model.sampleWomen
import com.raveline.compositing.ui.states.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {

    private val productsDao = ProductsDao()

    private val sections = mapOf(
        "All Products" to productsDao.productsList(),
        "Sales" to sampleDrinks + sampleCandies + sampleWomen,
        "Candies" to sampleCandies,
        "Drinks" to sampleDrinks,
        "Women" to sampleWomen,
    )

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            sections = sections,
            // When the value of text change, the state of home screen will also change
            onSearchChange = {
                uiState = uiState.copy(
                    inputText = it,
                    // Update products using the values passed by functions
                    searchedProducts = searchedProducts(it)
                )
            }
        )
    )
        private set


    private fun containsInNameOrDescription(
        text: String
    ) = { productItemModel: ProductItemModel ->
        (productItemModel.name.contains(text, true) ||
                productItemModel.description?.contains(text, true) == true)
    }

    private fun searchedProducts(text: String): List<ProductItemModel> =
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription(text)) +
                    productsDao.productsList().filter(containsInNameOrDescription(text))
        } else {
            emptyList()
        }

}