package com.example.auto_escola

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.auto_escola.src.presentation.customerdetatil.CustomerDetailScreen
import com.example.auto_escola.src.presentation.customerlist.CustomerListScreen
import com.example.auto_escola.src.utils.theme.Auto_escolaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Auto_escolaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController= rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routers.CustomerListScreen.route
                    ){
                        composable(
                            route = Routers.CustomerListScreen.route
                        ){
                            CustomerListScreen(navController)
                        }
                        composable(
                            route = Routers.CustomerDetailScreen.route+"/{customerEmail}"
                        ){
                            CustomerDetailScreen()
                        }
                    }
                }
            }
        }
    }
}