package com.example.delivery.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.delivery.dao.ProductDao
import com.example.delivery.model.Product
import com.example.delivery.model.ProductsSection
import com.example.delivery.sampledata.sampleProductsCandySection
import com.example.delivery.sampledata.sampleProductsDrinkSection
import com.example.delivery.sampledata.sampleProductsPromotionsSection
import com.example.delivery.ui.states.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    private val productSectionList = listOf(
        ProductsSection("Todos os Produtos", dao.getProducts()),
        sampleProductsCandySection,
        sampleProductsPromotionsSection,
        sampleProductsDrinkSection
    )
    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            onSearchTextChange = {
                uiState = uiState.copy(text = it, searchedProducts = getSearchedProducts(it))
            },
            productsSectionList = productSectionList,
        )
    )
        private set


    private fun getSearchedProducts(text: String): List<Product> {
        return productSectionList
            .flatMap { section ->
                section.products
            }
            .filter { product: Product ->
                product.name.contains(text, true)
                    || product.description?.contains(text, true)
                    ?: false
            }
    }
}