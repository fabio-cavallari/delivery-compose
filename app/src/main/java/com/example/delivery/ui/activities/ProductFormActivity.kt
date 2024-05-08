package com.example.delivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.delivery.ui.screens.ProductFormScreen
import com.example.delivery.ui.theme.DeliveryTheme

class ProductFormActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryTheme {
                Surface {
                    ProductFormScreen()
                }
            }
        }
    }
}