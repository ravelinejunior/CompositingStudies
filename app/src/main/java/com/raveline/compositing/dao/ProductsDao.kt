package com.raveline.compositing.dao

import androidx.compose.runtime.mutableStateListOf
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.model.sampleProducts

class ProductsDao {

    companion object {
        private val products = mutableStateListOf<ProductItemModel>(*sampleProducts.toTypedArray())
    }

    fun productsList() = products.toList()

    fun saveProduct(product: ProductItemModel) {
        products.add(0,product)
    }

}