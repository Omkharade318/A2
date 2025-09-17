package com.example.a2.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import ir.kaaveh.sdpcompose.ssp


@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RequestNotificationPermissionDialog(
    modifier: Modifier = Modifier,
    openDialog: MutableState<Boolean>,
    permissionState: PermissionState
) {

    if (openDialog.value) {
        BasicAlertDialog(
            onDismissRequest = {
                openDialog.value = false
                permissionState.launchPermissionRequest()
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false,
                decorFitsSystemWindows = true
            ),
        ) {

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    Text("Notification permission required", fontSize = 24.ssp)
                    Text(
                        "This app requires notification permission to show notifications",
                        fontSize = 18.ssp
                    )
                    TextButton(
                        onClick = {
                            openDialog.value = false
                            permissionState.launchPermissionRequest()
                        }
                    ) {
                        Text("Ok")
                    }
                }
            }
        }
    }

}