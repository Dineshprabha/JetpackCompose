package com.dinesh.jetpackcompose.RestApiFakerStore.domain

import com.dinesh.jetpackcompose.RestApiFakerStore.data.model.Product
import com.dinesh.jetpackcompose.RestApiFakerStore.data.network.APIInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProdRepository @Inject constructor(
    private val apiService: APIInterface
){

    suspend fun getProducts() : List<Product> {
        return try {
            apiService.getProducts()
        }
        catch (e:Exception) {
            emptyList()
        }
    }
}