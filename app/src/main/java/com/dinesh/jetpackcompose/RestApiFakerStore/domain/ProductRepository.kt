package com.dinesh.jetpackcompose.RestApiFakerStore.domain

import com.dinesh.jetpackcompose.RestApiFakerStore.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts() : Flow<List<Product>>
}