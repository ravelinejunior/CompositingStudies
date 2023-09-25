package com.raveline.compositing.ui.states

data class ProductFormUiState(
    val url: String = "https://thechive.com/wp-content/uploads/2023/09/6b0974ab-49f0-434e-aaed-ff219e6a0b71.jpg?attachment_cache_bust=4492400&quality=85&strip=info&w=600",
    val name: String = "",
    val price: String = "",
    val description: String = "",
    val onUrlChange: (String) -> Unit = {},
    val onNameChange: (String) -> Unit = {},
    val onDescriptionChange: (String) -> Unit = {},
    val onPriceChange: (String) -> Unit = {},
    val onSuccessClick: () -> Unit = {},
){
    val isShowPreview: Boolean get() = url.isNotBlank() && url.contains("https")
}
