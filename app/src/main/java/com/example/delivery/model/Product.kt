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