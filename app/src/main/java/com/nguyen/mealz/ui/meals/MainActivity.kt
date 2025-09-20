package com.nguyen.mealz.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nguyen.mealz.ui.theme.MealzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealzTheme {
                Categories()
            }
        }
    }
}

@Composable
fun Categories() {
    val viewModel: CategoryViewModel = viewModel()
    val meals = viewModel.getMeals()
    Text(text = "Hello Compose!")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzTheme {
        Categories()
    }
}