package com.dinesh.jetpackcompose.RestApiFakerStore.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dinesh.jetpackcompose.RestApiFakerStore.data.model.Product
import com.dinesh.jetpackcompose.RestApiFakerStore.presentation.ProductViewModel

@Composable
fun ProductsScreen(
    viewModel: ProductViewModel = hiltViewModel()
) {

    val products = viewModel.product.value
    LaunchedEffect(Unit) {
        viewModel.fetchProducts()
    }

    LazyColumn {
        items(products) {product ->
            ProductItem(product = product)
        }
    }

}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = product.title, style = MaterialTheme.typography.titleMedium)
            Text(text = product.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}