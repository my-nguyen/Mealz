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
    val meals = remember { mutableStateOf(listOf<Category>()) }
    val coroutineScope = rememberCoroutineScope()

    // LaunchedEffect is a Composable that allows things inside it be called only once, so that
    // no matter how many times the Composable Categories() is recomposed, the enclosed methods are
    // executed only once
    LaunchedEffect(key1 = "GET_MEALS") {
        coroutineScope.launch(Dispatchers.IO) {
            val data = viewModel.getMeals()
            meals.value = data
        }
    }
    LazyColumn {
        items(meals.value) {
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