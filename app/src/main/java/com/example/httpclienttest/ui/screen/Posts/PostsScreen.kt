package com.example.httpclienttest.ui.screen.Posts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.httpclienttest.ui.components.PostItem
import com.example.httpclienttest.ui.navigation.Destinations


@Composable
fun PostsListScreen(
    navController: NavController,
    postsListViewModel: PostsListViewModel = hiltViewModel()
) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        postsListViewModel.getAllPosts()
        isLoading = false
    }

    if (isLoading) {
        CircularProgressIndicator()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(postsListViewModel.posts) { post ->
                PostItem(
                    post = post,
                    onClick = {
                        navController.navigate("${Destinations.DETALLES_POSTS}/${post.id}")
                    }
                )
            }
        }
    }
}

