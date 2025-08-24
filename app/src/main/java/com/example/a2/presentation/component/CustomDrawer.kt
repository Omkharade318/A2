package com.example.a2.presentation.component

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.a2.domain.model.NavigationItem
import ir.kaaveh.sdpcompose.sdp
import com.example.a2.R
import com.example.a2.Screen
import com.example.a2.model.AuthState
import com.example.a2.model.AuthViewModel
import com.example.a2.presentation.auth.StartActivity
import com.example.a2.presentation.drawer.AboutUs
import com.example.a2.presentation.drawer.Help
import com.example.a2.presentation.drawer.Profile
import com.example.a2.presentation.drawer.Setting
import com.example.a2.ui.theme.LightGray

@Composable
fun CustomDrawer(
    modifier: Modifier,
    selectedNavigationItem: NavigationItem,
    onNavigationItemClick: (NavigationItem) -> Unit,
    onCloseClick: () -> Unit,
    navController: NavController
) {

    val authViewModel = AuthViewModel()
    val authState = authViewModel.authstate.observeAsState()

    val context = LocalContext.current
    val intent = Intent(context, StartActivity::class.java).apply {
        putExtra("message", "Clicked via Text!")
    }

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> context.startActivity(intent)
            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message,
                Toast.LENGTH_LONG
            ).show()

            else -> Unit
        }
    }

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(0.6f)
            .background(LightGray)
            .padding(horizontal = 12.sdp),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.sdp)
        ) {

            IconButton(
                modifier = modifier.systemBarsPadding(),
                onClick = onCloseClick
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Close Icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Spacer(modifier = Modifier.height(24.sdp))

        Image(
            modifier = Modifier.height(100.sdp),
            painter = painterResource(id = R.drawable.a2_logo),
            contentDescription = "Logo"
        )

        Spacer(modifier = Modifier.height(40.sdp))

        NavigationItemView(
            navigationItem = NavigationItem.Profile,
            selected = NavigationItem.Profile == selectedNavigationItem,
            onClick = {
                val intent = Intent(context, Profile::class.java).apply {
                    putExtra("message", "Clicked via Text!")
                }
                context.startActivity(intent)
            },
            navController = navController,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(4.sdp))

        NavigationItemView(
            navigationItem = NavigationItem.AboutUs,
            selected = NavigationItem.AboutUs == selectedNavigationItem,
            onClick = {
                val intent = Intent(context, AboutUs::class.java).apply {
                    putExtra("message", "Clicked via Text!")
                }
                context.startActivity(intent)
            },
            navController = navController,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(4.sdp))

        NavigationItemView(
            navigationItem = NavigationItem.Help,
            selected = NavigationItem.Help == selectedNavigationItem,
            onClick = {
                val intent = Intent(context, Help::class.java).apply {
                    putExtra("message", "Clicked via Text!")
                }
                context.startActivity(intent)
            },
            navController = navController,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(4.sdp))

        NavigationItemView(
            navigationItem = NavigationItem.Settings,
            selected = NavigationItem.Settings == selectedNavigationItem,
            onClick = {
                val intent = Intent(context, Setting::class.java).apply {
                    putExtra("message", "Clicked via Text!")
                }
                context.startActivity(intent)
            },
            navController = navController,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(4.sdp))

        Spacer(modifier = Modifier.weight(1f))

        NavigationItemView(
            navigationItem = NavigationItem.LogOut,
            selected = false,
            onClick = {
                authViewModel.signout()
            },
            navController = navController,
            modifier = Modifier.navigationBarsPadding()
        )
    }
}