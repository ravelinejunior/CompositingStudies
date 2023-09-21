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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raveline.compositing.model.sampleSections
import com.raveline.compositing.ui.components.CardProductItem
import com.raveline.compositing.ui.components.ProductsSection
import com.raveline.compositing.ui.components.SearchProductTextField
import com.raveline.compositing.ui.states.HomeScreenUiState
import com.raveline.compositing.ui.viewmodel.HomeScreenViewModel


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
fun HomeScreen(
    viewModel: HomeScreenViewModel,
) {
    val state by viewModel.uiState.collectAsState()

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