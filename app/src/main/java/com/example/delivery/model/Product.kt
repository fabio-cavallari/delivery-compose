package com.example.delivery.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.delivery.R
import java.math.BigDecimal

data class Product (
    val name: String,
    @DrawableRes val image: Int,
    val price: BigDecimal
)

val productList = listOf(
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