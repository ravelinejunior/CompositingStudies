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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raveline.compositing.R
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.model.sampleProducts
import com.raveline.compositing.model.sampleSections
import com.raveline.compositing.ui.components.CardProductItem
import com.raveline.compositing.ui.components.ProductsSection
import com.raveline.compositing.ui.components.SearchProductTextField

@Composable
fun HomeScreen(
    sections: Map<String, List<ProductItemModel>>,
    inputText: String = "",
) {
    Column {
        var text by remember {
            mutableStateOf(inputText)
        }

        SearchProductTextField(
            inputText = text,
            onSearchChange = {
                text = it
            })

        val searchedProducts = remember(key1 = text) {
            if (text.isNotBlank()) {
                sampleProducts.filter { productItemModel ->
                    (productItemModel.name.contains(text, true) ||
                            productItemModel.description?.contains(text, true) == true)
                }
            } else {
                emptyList()
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (text.isBlank()) {
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sections = sampleSections)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenWithPrevTextPreview() {
    HomeScreen(
        sections = sampleSections,
        inputText = stringResource(R.string.search)
    )
}