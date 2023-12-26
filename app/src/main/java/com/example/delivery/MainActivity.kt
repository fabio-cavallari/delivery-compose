package com.example.delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.delivery.model.ProductsSection
import com.example.delivery.sampledata.sampleProductsSectionList
import com.example.delivery.ui.screens.HomeScreen
import com.example.delivery.ui.theme.DeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(sampleProductsSectionList)
        }
    }
}
@Composable
private fun App(productsSectionList: List<ProductsSection>) {
    DeliveryTheme {
        Surface {
            HomeScreen(productsSectionList)
        }
    }
}