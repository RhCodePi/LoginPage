package com.example.loginpagetest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavHost(
    navController : NavHostController
){

    NavHost(
        navController = navController,
        startDestination = "login_screen"
    )
    {
        composable(
            route = Screen.Login.route
        ){
            LoginPage(navController = navController)
        }
        composable(
            route = Screen.Home.route
        ){
            HomePage(navController = navController)
        }
    }

}