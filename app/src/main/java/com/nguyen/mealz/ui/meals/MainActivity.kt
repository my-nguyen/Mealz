package com.nguyen.mealz.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nguyen.mealz.model.network.Category
import com.nguyen.mealz.ui.theme.MealzTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    val meals = viewModel.meals.value

    LazyColumn {
        items(meals) {
            Text(text = it.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzTheme {
        Categories()
    }
}