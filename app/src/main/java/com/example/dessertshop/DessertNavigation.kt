package com.example.dessertshop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dessertshop.ui.theme.DessertTrackerScreen

sealed class Screen(val route: String){
    object Home:Screen("home")
    object DessertTracker:Screen("dessert_tracker")
    object AddDessert:Screen("add_dessert")
}

@Composable
fun DessertAppNavHost(){
    val navController= rememberNavController()
    NavHost(navController=navController,startDestination=Screen.Home.route){
        composable(Screen.Home.route) {HomeScreen(navController)}
        composable(Screen.DessertTracker.route){ DessertTrackerScreen()}
        composable(Screen.AddDessert.route){AddDesertScreen(navController )}
    }
}

@Composable
fun HomeScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = {navController.navigate(Screen.DessertTracker.route) }) {
            Text(text = "Track Dessert")
        }
        Button(onClick = { navController.navigate(Screen.AddDessert.route)}) {
            Text(text = "Add Dessert")
        }
    }
}

@Composable
fun AddDesertScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = {navController.popBackStack()}) {
            Text(text = "Go back")
        }
        Text(text = "Add a new dessert here!", style = MaterialTheme.typography.headlineMedium)
    }
}