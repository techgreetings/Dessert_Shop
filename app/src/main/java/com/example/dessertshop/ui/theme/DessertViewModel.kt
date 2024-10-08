package com.example.dessertshop.ui.theme

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

class DessertViewModel: ViewModel() {
    private val _dessertSold = mutableStateOf(0)
    val dessertSold :State<Int> =_dessertSold

    fun sellDessert(){
        _dessertSold.value=_dessertSold.value+1
    }
}