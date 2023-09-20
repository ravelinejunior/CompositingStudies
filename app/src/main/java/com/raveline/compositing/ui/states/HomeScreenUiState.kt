package com.raveline.compositing.ui.states

import com.raveline.compositing.model.ProductItemModel

data class HomeScreenUiState(
    val sections: Map<String, List<ProductItemModel>> = emptyMap(),
    val searchedProducts: List<ProductItemModel> = emptyList(),
    val inputText: String = String(),
    val onSearchChange: (String) -> Unit = {}

) {
    fun isShowSections(): Boolean = inputText.isBlank()
}
