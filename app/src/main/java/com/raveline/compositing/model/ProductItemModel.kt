package com.raveline.compositing.model

import java.math.BigDecimal

data class ProductItemModel(
    val name: String,
    val description: String? = "",
    val price: BigDecimal,
    val image: String? = "https://thechive.com/wp-content/uploads/2023/09/6b0974ab-49f0-434e-aaed-ff219e6a0b71.jpg?attachment_cache_bust=4492400&quality=85&strip=info&w=600"
)