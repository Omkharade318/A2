package com.example.a2

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object LogIn : Screen("login_screen")
    object SignUp : Screen("signup_screen")
    object Home : Screen("home_screen")
    object Chat : Screen("chat_screen")
    object Profile : Screen("profile_screen")
    object Settings : Screen("settings_screen")
    object AboutUs : Screen("aboutus_screen")
    object LogOut : Screen("logout_screen")
}