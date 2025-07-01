package com.example.a2.presentation.drawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.a2.Screen
import com.example.a2.ui.theme.Blue
import com.example.a2.ui.theme.OffWhite
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

class AboutUs : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AboutUsScreen()
        }
    }
}

@Composable
fun AboutUsScreen(){

    val navController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .background(Blue)
                    .statusBarsPadding()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(Screen.Home.route)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back Icon",
                        tint = Color.White
                    )
                }

                Text(
                    text = "About Us",
                    color = Color.White,
                    fontSize = 18.ssp
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .padding(18.sdp),
                    colors = CardColors(
                        containerColor = OffWhite,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Black,
                        disabledContainerColor = Color.White
                    )
                ) {

                    Text(
                        text = "A2lytics Private Limited is a growing software company focused on software development and training." +
                                "\n\nWe develop software in domains like enterprise solutions, web and mobile applications, data analytics, and digital marketing.\n\n" +
                                "We provide training in data science, deep learning, full-stack development, cloud computing, DevOps, and more.\n\n" +
                                "We also offer internships for Diploma, Engineering, BCA, and MCA students, allowing them to work on live projects.",
                        Modifier.padding(8.sdp),
                        fontSize = 16.ssp
                    )

                }
            }
        }
    }
}