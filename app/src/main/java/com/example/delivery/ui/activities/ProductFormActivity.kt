package com.example.delivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.delivery.dao.ProductDao
import com.example.delivery.ui.screens.ProductFormScreen
import com.example.delivery.ui.theme.DeliveryTheme

class ProductFormActivity: ComponentActivity() {
    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryTheme {
                Surface {
                    ProductFormScreen(
                        onSaveClick = {
                            dao.save(it)
                            finish()
                        }
                    )
                }
            }
        }
    }
}