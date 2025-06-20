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
import ir.kaaveh.sdpcompose.sdp

@Composable
fun Navigation(){

    val navController = rememberNavController()
    val chatViewModel : ChatViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(route = Screen.Chat.route){
            ChatPage(
                modifier = Modifier.padding(16.sdp),
                viewModel = chatViewModel,
                navController = navController
            )
        }


    }
}