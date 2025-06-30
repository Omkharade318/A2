package com.example.a2.presentation.home

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.a2.domain.model.CustomDrawerState
import com.example.a2.domain.model.NavigationItem
import com.example.a2.domain.model.isOpened
import com.example.a2.presentation.component.CustomDrawer
import kotlin.math.roundToInt
import com.example.a2.R
import com.example.a2.domain.model.opposite
import ir.kaaveh.sdpcompose.sdp

@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {

    val navController = rememberNavController()

    var drawerState by remember { mutableStateOf(CustomDrawerState.Closed) }
    var selectedNavigationItem by remember { mutableStateOf(NavigationItem.LogOut) }

    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density

    val screenWidth = remember {
        derivedStateOf { (configuration.screenWidthDp * density).roundToInt() }
    }

    val offsetValue by remember {
        derivedStateOf {
            (screenWidth.value / 4.5).dp
        }
    }

    val animatedDrawerOffset by animateDpAsState(
        targetValue = if (drawerState.isOpened()) 0.dp else (-offsetValue),
        label = "Drawer Offset",
        animationSpec = spring(
            dampingRatio = 0.8f,
            stiffness = Spring.StiffnessLow
        )
    )

    val animatedContentOffset by animateDpAsState(
        targetValue = if (drawerState.isOpened()) offsetValue else 0.dp,
        label = "Content Offset",
        animationSpec = spring(
            dampingRatio = 0.8f,
            stiffness = Spring.StiffnessLow
        )
    )

    val animatedScale by animateFloatAsState(
        targetValue = if (drawerState.isOpened()) 0.9f else 1f,
        label = "Animated Scale",
        animationSpec = spring(
            dampingRatio = 0.8f,
            stiffness = Spring.StiffnessLow
        )
    )

    BackHandler(enabled = drawerState.isOpened()) {
        drawerState = CustomDrawerState.Closed
    }


    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        CustomDrawer(
            modifier = Modifier.offset(x = animatedDrawerOffset),
            selectedNavigationItem = selectedNavigationItem,
            onNavigationItemClick = {
                selectedNavigationItem = it
            },
            onCloseClick = {
                drawerState = CustomDrawerState.Closed
            },
            navController = navController
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(x = animatedContentOffset)
                .scale(animatedScale)
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {

            Row (
                modifier = Modifier
                    .padding(start = 24.sdp)
                    .systemBarsPadding()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.sdp)
                        .clickable {
                        drawerState = drawerState.opposite()
                    }
                )

                Image(
                    modifier = Modifier.padding(8.sdp),
                    painter = painterResource(R.drawable.a2_logo),
                    contentDescription = "logo"
                )
            }
        }
    }
}
