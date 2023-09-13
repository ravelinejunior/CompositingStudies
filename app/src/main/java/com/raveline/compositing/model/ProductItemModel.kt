package com.raveline.compositing.model

import java.math.BigDecimal

data class ProductItemModel(
    val name: String,
    val description: String? = "",
    val price: BigDecimal,
    val image: String? = "https://images.unsplash.com/photo-1515161318750-781d6122e367?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1952&q=80"
)