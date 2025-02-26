package com.example.httpclienttest.ui.screen.Posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.httpclienttest.data.model.Posts
import com.example.httpclienttest.data.repositories.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostsListViewModel @Inject constructor(
    private val postsRepository: PostsRepository
) : ViewModel() {

    // Estado que almacena la lista de productos obtenidos
    var posts by mutableStateOf(listOf<Posts>())
        private set // Solo puede ser modificado dentro del ViewModel


    suspend fun getAllPosts(): List<Posts> {
        val result =
            postsRepository.fetchPosts() // Obtención de productos desde el repositorio
        if (result != null) {
            this.posts = result // Actualización del estado con los productos obtenidos
        }
        return this.posts // Retorna la lista de productos actualizada
    }
}
