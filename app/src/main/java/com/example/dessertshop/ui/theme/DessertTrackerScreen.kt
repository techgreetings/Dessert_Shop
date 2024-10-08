package com.example.dessertshop.ui.theme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.*

@Composable
fun  DessertTrackerScreen(viewModel: DessertViewModel = viewModel()) {
    val dessertSold = viewModel.dessertSold.value
    Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ){
     Text(text = "Dessert Sold: $dessertSold", style= MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {viewModel.sellDessert()}) {
            Text(text = "Sell Desert")
        }
    }
}