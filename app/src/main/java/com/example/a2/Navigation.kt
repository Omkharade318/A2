package com.example.a2

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a2.model.ChatViewModel
import com.example.a2.presentation.ChatPage
import com.example.a2.presentation.auth.LogInScreen
import com.example.a2.presentation.auth.SignUpScreen
import com.example.a2.presentation.drawer.AboutUsScreen
import com.example.a2.presentation.drawer.HelpScreen
import com.example.a2.presentation.drawer.ProfileScreen
import com.example.a2.presentation.home.HomeScreen
import ir.kaaveh.sdpcompose.sdp

@Composable
fun Navigation(){

    val navController = rememberNavController()
    val chatViewModel : ChatViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.LogIn.route
    ) {

        composable(route = Screen.LogIn.route){
            LogInScreen(navController = navController)
        }

        composable(route = Screen.SignUp.route){
            SignUpScreen(navController = navController)
        }

        composable(route = Screen.Home.route){
            HomeScreen()
        }

        composable(route = Screen.Chat.route){
            ChatPage(
                modifier = Modifier.padding(16.sdp),
                viewModel = chatViewModel,
                navController = navController
            )
        }

        composable(route = Screen.AboutUs.route){
            AboutUsScreen()
        }

        composable(route = Screen.Help.route){
            HelpScreen()
        }

        composable(route = Screen.Profile.route){
            ProfileScreen()
        }

    }
}