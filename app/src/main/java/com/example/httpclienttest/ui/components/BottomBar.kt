package com.example.httpclienttest.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.httpclienttest.ui.navigation.Destinations
import java.lang.reflect.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Star

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    onHomeClick: () -> Unit,
) {
    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
    ) {
// Item para Home
        NavigationBarItem(
            selected = currentRoute == Destinations.LISTA_POSTS,
            onClick = onHomeClick,
            label = { Text("Home", color = Color.White) },
            icon = {
                Icon(
                    Icons.Filled.Home, contentDescription =
                    "Home"
                )
            }
        )

    }
}