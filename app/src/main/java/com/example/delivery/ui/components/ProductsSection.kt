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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.model.ProductsSection
import com.example.delivery.sampledata.sampleProductsSection1

@Composable
fun ProductsSection(productsSection: ProductsSection) {
    Column {
        Text(
            text = productsSection.title,
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
            productsSection.products.forEach { product ->
                ProductItem(product = product)
            }
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSectionPreview() {
    ProductsSection(sampleProductsSection1)
}