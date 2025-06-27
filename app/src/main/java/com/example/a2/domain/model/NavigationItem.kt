package com.example.a2.domain.model

import com.example.a2.R

enum class NavigationItem(
    val title: String,
    val icon: Int
) {

    Profile(
        icon = R.drawable.ic_profile,
        title = "Profile"
    ),

    AboutUs(
        icon = R.drawable.ic_about_us,
        title = "About Us"
    ),

    Help(
        icon = R.drawable.ic_help,
        title = "Help"
    ),

    Settings(
        icon = R.drawable.ic_settings,
        title = "Settings"
    ),

    LogOut(
        icon = R.drawable.ic_logout,
        title = "LogOut"
    )

}