package com.example.a2.presentation.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.a2.Screen
import com.example.a2.domain.model.NavigationItem
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun NavigationItemView(
    modifier: Modifier,
    navigationItem: NavigationItem,
    selected: Boolean,
    onClick: () -> Unit,
    navController: NavController
){

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(size = 99.sdp))
            .clickable {
                // Then navigate
                try {
                    onClick()
                    val route = when (navigationItem) {
                        NavigationItem.Profile -> Screen.Profile.route
                        NavigationItem.Settings -> Screen.Settings.route
                        NavigationItem.Help -> Screen.Chat.route
                        NavigationItem.AboutUs -> Screen.AboutUs.route
                        NavigationItem.LogOut -> Screen.LogOut.route
                    }
                    navController.navigate(route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        popUpTo(Screen.Home.route) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                } catch (e: Exception) {
                    // Handle navigation errors
                    Log.e("Navigation", "Error navigating to ${navigationItem.title}", e)
                }
            }
            .background(
                color =  if (selected) MaterialTheme.colorScheme.surfaceColorAtElevation(4.sdp) else Color.Unspecified,
                shape = RoundedCornerShape(99.sdp)
            )
            .padding(horizontal = 12.sdp, vertical = 8.sdp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = navigationItem.icon),
            contentDescription = "Navigation Item Icon",
            tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.width(12.sdp))

        Text(
            text = navigationItem.title,
            color = if(selected) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurface,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            lineHeight = 20.ssp
        )

    }
}