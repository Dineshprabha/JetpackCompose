package com.dinesh.jetpackcompose.RestApiFakerStore.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.jetpackcompose.RestApiFakerStore.data.model.Product
import com.dinesh.jetpackcompose.RestApiFakerStore.domain.ProdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProdRepository
) : ViewModel() {

    private val _product = mutableStateOf<List<Product>>(emptyList())
    val product : State<List<Product>> = _product



    fun fetchProducts() {
        viewModelScope.launch {
            val productList = repository.getProducts()
            _product.value = productList
        }
    }
}