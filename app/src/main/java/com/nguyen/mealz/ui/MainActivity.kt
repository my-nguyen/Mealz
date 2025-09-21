package com.nguyen.mealz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nguyen.mealz.ui.details.DetailViewModel
import com.nguyen.mealz.ui.details.DetailsScreen
import com.nguyen.mealz.ui.meals.CategoriesScreen
import com.nguyen.mealz.ui.theme.MealzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealzTheme {
                MainScreen()
            }
        }
    }
}

@Composable
private fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destination_meals") {
        composable(route = "destination_meals") {
            CategoriesScreen { id ->
                navController.navigate("destination_detail/$id")
            }
        }
        composable(
            route = "destination_detail/{meal_id}",
            arguments = listOf(navArgument("meal_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: DetailViewModel = viewModel()
            DetailsScreen(viewModel.mealState.value)
        }
    }
}