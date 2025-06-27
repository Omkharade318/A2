package com.example.a2.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.a2.domain.model.NavigationItem
import ir.kaaveh.sdpcompose.sdp
import com.example.a2.R

@Composable
fun CustomDrawer(
    modifier: Modifier,
    selectedNavigationItem: NavigationItem,
    onNavigationItemClick: (NavigationItem) -> Unit,
    onCloseClick: () -> Unit
){

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(0.6f)
            .padding(horizontal = 12.sdp),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.sdp)
        ) {

            IconButton(
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

        NavigationItem.entries.toTypedArray().take(4).forEach { navigationItem ->
            NavigationItemView(
                navigationItem = navigationItem,
                selected = navigationItem == selectedNavigationItem,
                onClick = { onNavigationItemClick(navigationItem) }
            )
            Spacer(modifier = Modifier.height(4.sdp))
        }
        Spacer(modifier = Modifier.weight(1f))

        NavigationItem.entries.toTypedArray().takeLast(1).forEach { navigationItem ->
            NavigationItemView(
                navigationItem = navigationItem,
                selected = false,
                onClick = {
                    when(navigationItem){
                        NavigationItem.LogOut -> {
                            onNavigationItemClick(NavigationItem.LogOut)
                        }

                        else-> {

                        }
                    }
                }
            )
        }
    }
}