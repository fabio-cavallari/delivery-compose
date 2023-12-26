package com.example.delivery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.R
import com.example.delivery.model.Product
import java.math.BigDecimal

@Composable
fun ProductsSection(productList: List<Product>) {
    Column {
        Text(
            text = "Promoção",
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(Modifier)
            productList.forEach { product ->
                ProductItem(product = product)
            }
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSectionPreview() {
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
    ProductsSection(productList)
}