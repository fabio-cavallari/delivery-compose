package com.example.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.delivery.model.ProductsSection
import com.example.delivery.sampledata.sampleProductsSectionList
import com.example.delivery.ui.components.ProductsSection
import com.example.delivery.ui.components.SearchProductItem
import com.example.delivery.ui.components.SearchTextField

@Composable
fun HomeScreen(
    productsSectionList: List<ProductsSection>,
    searchText: String = ""
) {
    Column {
        var text by remember {
            mutableStateOf(searchText)
        }
        val products = remember {
            productsSectionList.flatMap { productSection ->
                productSection.products
            }
        }
        val searchedProducts = remember(text) {
            products.filter { product ->
                product.name.contains(text, true) || product.description?.contains(
                    text,
                    true
                ) ?: false
            }
        }
        SearchTextField(
            searchText = text,
            onSearchTextChange = {
                text = it
            }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (text.isBlank()) {
                items(productsSectionList) { productSection ->
                    ProductsSection(productsSection = productSection)
                }
            } else {
                items(searchedProducts) { product ->
                    SearchProductItem(
                        product = product,
                        modifier = Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sampleProductsSectionList)
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenWithSearchTextPreview() {
    HomeScreen(sampleProductsSectionList, "pizza")
}