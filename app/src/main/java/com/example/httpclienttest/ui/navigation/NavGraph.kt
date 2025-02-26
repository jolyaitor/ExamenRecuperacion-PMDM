package com.example.httpclienttest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.httpclienttest.ui.screen.CaracteristicasPosts.CaracteristicasPostsScreen
import com.example.httpclienttest.ui.screen.Posts.PostsListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.LISTA_POSTS
    ) {
        composable(Destinations.LISTA_POSTS) {
            PostsListScreen(navController = navController)
        }

        composable(
            route = "${Destinations.DETALLES_POSTS}/{postsId}",
            arguments = listOf(
                navArgument("") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val postsId = backStackEntry.arguments?.getInt("postsId") ?: 0
            CaracteristicasPostsScreen(postsId = postsId)
        }
    }
}