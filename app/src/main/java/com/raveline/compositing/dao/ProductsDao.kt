package com.raveline.compositing.dao

import com.raveline.compositing.model.ProductItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductsDao {

    companion object {
        private val products = MutableStateFlow<List<ProductItemModel>>(emptyList())
    }

    fun productsList(): StateFlow<List<ProductItemModel>> = products.asStateFlow()

    fun saveProduct(product: ProductItemModel) {
        products.value = products.value + product
    }

}