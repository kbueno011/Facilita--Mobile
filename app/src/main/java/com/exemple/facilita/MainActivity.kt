package com.exemple.facilita

import TelaInicio1
import TelaInicio2
import TelaInicio3
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exemple.facilita.screens.TelaLogin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavHost(navController)
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "tela_inicio2"
    ) {
        composable("tela_inicio2") {
            TelaInicio1(navController)
        }
        composable("tela_inicio3") {
            TelaInicio2(navController)
        }
        composable("tela_inicio4") {
            TelaInicio3(navController)
        }
        composable("tela_login") {
            TelaLogin(navController)
        }
    }
}
