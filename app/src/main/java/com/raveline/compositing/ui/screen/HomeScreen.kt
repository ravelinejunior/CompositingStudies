package com.raveline.compositing.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raveline.compositing.dao.ProductsDao
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.model.sampleCandies
import com.raveline.compositing.model.sampleDrinks
import com.raveline.compositing.model.sampleProducts
import com.raveline.compositing.model.sampleSections
import com.raveline.compositing.model.sampleWomen
import com.raveline.compositing.ui.components.CardProductItem
import com.raveline.compositing.ui.components.ProductsSection
import com.raveline.compositing.ui.components.SearchProductTextField

val dao = ProductsDao()

class HomeScreenUiState(
    val sections: Map<String, List<ProductItemModel>> = emptyMap(),
    val searchedProducts: List<ProductItemModel> = emptyList(),
    val inputText: String = String(),
    val onSearchChange: (String) -> Unit = {}

) {
    fun isShowSections(): Boolean = inputText.isBlank()

}


@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
) {

    Column {
        val sections = state.sections
        val text = state.inputText
        val searchedProducts = remember(text, sections) {
            state.searchedProducts
        }

        SearchProductTextField(
            inputText = text,
            onSearchChange = state.onSearchChange,
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val productList = section.value
                    item {
                        ProductsSection(title, productList)
                    }
                }
            } else {
                items(searchedProducts) { product ->
                    CardProductItem(product = product, modifier = Modifier.padding(16.dp))
                }
            }


        }
    }
}

@Composable
fun HomeScreen(productsDao: List<ProductItemModel>) {
    val sections = mapOf(
        "All Products" to productsDao,
        "Sales" to sampleDrinks + sampleCandies,
        "Candies" to sampleCandies,
        "Drinks" to sampleDrinks,
        "Women" to sampleWomen,
    )

    var text by remember {
        mutableStateOf(String())
    }

    fun containsInNameOrDescription() = { productItemModel: ProductItemModel ->
        (productItemModel.name.contains(text, true) ||
                productItemModel.description?.contains(text, true) == true)
    }

    val searchedProducts = remember(text, productsDao) {
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription()) +
                    productsDao.filter(containsInNameOrDescription())
        } else {
            emptyList()
        }
    }

    val state = remember(productsDao, text) {
        HomeScreenUiState(
            sections = sections,
            searchedProducts = searchedProducts,
            inputText = text,
            onSearchChange = {
                text = it
            }
        )
    }

    HomeScreen(state = state)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        state = HomeScreenUiState(sections = sampleSections)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenWithPrevTextPreview() {
    HomeScreen(
        state = HomeScreenUiState(inputText = "Lorem", sections = sampleSections),
    )
}