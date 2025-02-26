package com.example.httpclienttest.ui.screen.CaracteristicasPosts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.httpclienttest.data.model.Posts
import com.example.httpclienttest.data.repositories.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CaracteristicasPostsViewModel @Inject constructor(
    private val postsRepository: PostsRepository
) : ViewModel() {

    var posts by mutableStateOf<Posts?>(null)
        private set // 'private set' impide modificaciones externas, asegurando encapsulación.

    var errorMessage by mutableStateOf<String?>(null)
        private set


    suspend fun getPosts(id: Int) {
        val result =
            postsRepository.getPostbyId(id = id)

        if (result != null) {
            this.posts = result
            this.errorMessage = null
        } else {
            this.errorMessage =
                "Null"
        }
    }
}
