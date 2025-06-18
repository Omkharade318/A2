package com.example.a2.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions


@Composable
fun SplashScreen(navController: NavController){

}

@Preview
@Composable
fun SpashPreview() {
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}
