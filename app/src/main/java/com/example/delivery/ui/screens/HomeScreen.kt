package com.example.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.delivery.sampledata.sampleProductsSectionList
import com.example.delivery.ui.components.ProductsSection
import com.example.delivery.ui.components.SearchProductItem
import com.example.delivery.ui.components.SearchTextField
import com.example.delivery.ui.states.HomeScreenUiState
import com.example.delivery.viewmodels.HomeScreenViewModel


@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    val state = viewModel.uiState
    HomeScreen(state)
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState
) {
    Column {
        SearchTextField(
            searchText = state.text,
            onSearchTextChange = state.onSearchTextChange
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.showSections()) {
                items(state.productsSectionList) { productSection ->
                    if (productSection.products.isNotEmpty()) {
                        ProductsSection(productsSection = productSection)
                    }
                }
            } else {
                items(state.searchedProducts) { product ->
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
    HomeScreen(HomeScreenUiState(sampleProductsSectionList))
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenWithSearchTextPreview() {
    HomeScreen(HomeScreenUiState(sampleProductsSectionList, ""))
}