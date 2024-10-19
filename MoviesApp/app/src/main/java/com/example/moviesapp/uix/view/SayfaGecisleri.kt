package com.example.moviesapp.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SayfaGecis(){
    val navController = rememberNavController()
    NavHost(navController= navController , startDestination = "anasayfa"){

        composable("anasayfa"){
            Anasayfa(navController = navController)
        }

        composable("detaySayfa"){
            DetaySayfa()
        }
    }
}