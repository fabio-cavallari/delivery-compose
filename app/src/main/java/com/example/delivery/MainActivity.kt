package com.example.delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.delivery.model.Product
import com.example.delivery.model.productList
import com.example.delivery.ui.components.ProductItem
import com.example.delivery.ui.components.ProductsSection
import com.example.delivery.ui.screens.HomeScreen
import com.example.delivery.ui.theme.DeliveryTheme
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(productList)
        }
    }
}
@Composable
private fun App(productList: List<Product>) {
    DeliveryTheme {
        Surface {
            HomeScreen(productList)
        }
    }
}