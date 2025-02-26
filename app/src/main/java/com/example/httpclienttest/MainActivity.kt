package com.example.httpclienttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.httpclienttest.ui.components.BottomNavigationBar
import com.example.httpclienttest.ui.components.Topbar
import com.example.httpclienttest.ui.navigation.Destinations
import com.example.httpclienttest.ui.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val currentRoute = remember { mutableStateOf(Destinations.LISTA_POSTS) }
    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentRoute.value = destination.route ?: Destinations.LISTA_POSTS
        }
    }
    Scaffold(
        topBar = { Topbar(currentRoute) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavGraph(navController)
            }

        },
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentRoute.value,
                onHomeClick = {
                    navController.navigate(Destinations.LISTA_POSTS)
                },

                )
        },
        modifier = Modifier.fillMaxSize()
    )
}


