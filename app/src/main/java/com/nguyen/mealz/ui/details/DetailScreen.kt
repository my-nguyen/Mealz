package com.nguyen.mealz.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.nguyen.mealz.model.network.Category

@Composable
fun DetailsScreen(meal: Category?) {
    var isExpanded by remember { mutableStateOf(false) }
    val imageSize: Dp by animateDpAsState(if (isExpanded) 200.dp else 100.dp)

    Column {
        Row {
            Card {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(meal?.imageUrl)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSize)
                        .padding(8.dp)
                )
            }
            Text(
                meal?.name ?: "default name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(modifier = Modifier.padding(16.dp), onClick = {
            isExpanded = !isExpanded
        }) {
            Text("Change picture state")
        }
    }
}