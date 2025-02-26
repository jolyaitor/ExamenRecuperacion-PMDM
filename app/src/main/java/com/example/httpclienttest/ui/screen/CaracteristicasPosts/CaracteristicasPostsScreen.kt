package com.example.httpclienttest.ui.screen.CaracteristicasPosts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.httpclienttest.ui.components.CaracteristicasPostsItem


@Composable
fun CaracteristicasPostsScreen(
    postsId: Int,
    CaracteristicasPostsViewModel: CaracteristicasPostsViewModel = hiltViewModel()
) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        CaracteristicasPostsViewModel.getPosts(postsId)
        isLoading = false
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        CaracteristicasPostsViewModel.posts?.let { post ->
            CaracteristicasPostsItem((post))
        }
    }
}
