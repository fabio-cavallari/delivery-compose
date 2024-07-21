package com.example.delivery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.delivery.dao.ProductDao
import com.example.delivery.sampledata.sampleProductsSectionList
import com.example.delivery.ui.screens.HomeScreen
import com.example.delivery.ui.states.HomeScreenUiState
import com.example.delivery.ui.theme.DeliveryTheme
import com.example.delivery.viewmodels.HomeScreenViewModel

class MainActivity : ComponentActivity() {
    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                onFabClick = {
                    startActivity(
                        Intent(this, ProductFormActivity::class.java)
                    )
                },
                content = {
                    val viewModel by viewModels<HomeScreenViewModel>()
                    HomeScreen(viewModel = viewModel)
                }
            )
        }
    }
}

@Composable
private fun App(onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
    DeliveryTheme {
        Surface {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = onFabClick) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    }
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AppPreview() {
    App(
        content = {
            HomeScreen(HomeScreenUiState(sampleProductsSectionList))
        }
    )
}