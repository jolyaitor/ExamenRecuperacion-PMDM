package com.example.httpclienttest.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.httpclienttest.ui.navigation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(currentRoute: MutableState<String>) {
    val texto by remember {
        derivedStateOf {
            if (currentRoute.value == Destinations.LISTA_POSTS) {
                "Posts"
            } else {
                "Detalles"
            }
        }
    }

    TopAppBar(
        title = {
            Text(
                texto,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = 40.sp
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
        colors = TopAppBarDefaults.topAppBarColors(Color.Black),
    )
}