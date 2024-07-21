package com.example.delivery.ui.states

import com.example.delivery.model.Product
import com.example.delivery.model.ProductsSection

data class HomeScreenUiState(
    val productsSectionList: List<ProductsSection> = listOf(),
    val text: String = "",
    val searchedProducts: List<Product> = listOf(),
    val onSearchTextChange: (String) -> Unit = {},
) {
    fun showSections() = text.isBlank()
}
