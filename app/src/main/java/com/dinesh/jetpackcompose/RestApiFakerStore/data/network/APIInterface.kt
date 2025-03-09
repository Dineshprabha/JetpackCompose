package com.dinesh.jetpackcompose.RestApiFakerStore.data.network

import com.dinesh.jetpackcompose.RestApiFakerStore.data.model.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface APIInterface {

    @GET("products")
    suspend fun getProducts() : List<Product>
}