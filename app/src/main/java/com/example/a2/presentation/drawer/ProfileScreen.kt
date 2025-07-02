package com.example.a2.presentation.drawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.a2.Screen
import com.example.a2.ui.theme.Blue
import com.example.a2.ui.theme.OffWhite
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {

    val navController = rememberNavController()

    var name by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var schoolName by remember { mutableStateOf("") }
    var educationBoard by remember { mutableStateOf("") }
    var className by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top AppBar
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

        Spacer(modifier = Modifier.height(16.sdp))

        // Card-like container
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.sdp),
            shape = RoundedCornerShape(12.sdp),
            elevation = CardDefaults.cardElevation(4.sdp),
            colors = CardColors(
                containerColor = OffWhite,
                contentColor = Color.Black,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.White
            )
        ) {
            LazyColumn(modifier = Modifier.padding(16.sdp)) {

                item {

                    Text("1. Basic Information", fontWeight = FontWeight.Bold, fontSize = 16.ssp)
                    Spacer(modifier = Modifier.height(8.sdp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") },
                        placeholder = { Text("Enter Name") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(12.sdp)
                    )

                    Spacer(modifier = Modifier.height(8.sdp))

                    OutlinedTextField(
                        value = mobile,
                        onValueChange = { mobile = it },
                        label = { Text("Mobile No") },
                        placeholder = { Text("Enter Mobile No.") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(12.sdp)
                    )

                    Spacer(modifier = Modifier.height(8.sdp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        placeholder = { Text("Enter Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(12.sdp)
                    )

                    Spacer(modifier = Modifier.height(16.sdp))

                    Text("2. Address", fontWeight = FontWeight.Bold, fontSize = 16.ssp)
                    Spacer(modifier = Modifier.height(8.sdp))

                    OutlinedTextField(
                        value = address,
                        onValueChange = { address = it },
                        placeholder = { Text("Enter your address here...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.sdp),
                        singleLine = false,
                        maxLines = 5,
                        shape = RoundedCornerShape(12.sdp)
                    )

                    Spacer(modifier = Modifier.height(16.sdp))

                    Text("3. Educational Details", fontWeight = FontWeight.Bold, fontSize = 16.ssp)
                    Spacer(modifier = Modifier.height(8.sdp))

                    OutlinedTextField(
                        value = schoolName,
                        onValueChange = { schoolName = it },
                        label = { Text("School Name") },
                        placeholder = { Text("Name of your School") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(12.sdp)
                    )

                    Spacer(modifier = Modifier.height(8.sdp))

                    OutlinedTextField(
                        value = educationBoard,
                        onValueChange = { educationBoard = it },
                        label = { Text("Education Board") },
                        placeholder = { Text("Name of your Education Board") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(12.sdp)
                    )

                    Spacer(modifier = Modifier.height(8.sdp))

                    OutlinedTextField(
                        value = className,
                        onValueChange = { className = it },
                        label = { Text("Class") },
                        placeholder = { Text("Class you are studying in") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(12.sdp)
                    )

                    Spacer(modifier = Modifier.height(24.sdp))

                    // Submit Button
                    Button(
                        onClick = { /* Submit Logic */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.sdp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF)),
                        shape = RoundedCornerShape(8.sdp)
                    ) {
                        Text("SUBMIT", color = Color.White)
                    }
                }
            }
        }
    }
}
