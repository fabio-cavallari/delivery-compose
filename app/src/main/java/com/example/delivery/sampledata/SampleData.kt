package com.example.delivery.sampledata

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.delivery.R
import com.example.delivery.model.Product
import com.example.delivery.model.ProductsSection
import java.math.BigDecimal

val sampleProductList = listOf(
    Product(
        name = LoremIpsum(50).values.first(),
        price = BigDecimal("14.99"),
        image = R.drawable.ic_launcher_background
    ),
    Product(
        name = LoremIpsum(50).values.first(),
        price = BigDecimal("10.99"),
        image = R.drawable.ic_launcher_background
    ),
    Product(
        name = LoremIpsum(50).values.first(),
        price = BigDecimal("20.99"),
        image = R.drawable.ic_launcher_background
    )
)
val sampleProductsSection1 = ProductsSection("Promoções", sampleProductList)
val sampleProductsSection2 = ProductsSection("Favoritos", sampleProductList)
val sampleProductsSection3 = ProductsSection("Últimos Vistos", sampleProductList)
val sampleProductsSectionList =
    listOf(sampleProductsSection1, sampleProductsSection2, sampleProductsSection3)