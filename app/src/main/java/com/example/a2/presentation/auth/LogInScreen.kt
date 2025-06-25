package com.example.a2.presentation.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a2.Navigation
import com.example.a2.R
import com.example.a2.Screen
import dagger.hilt.android.AndroidEntryPoint
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@AndroidEntryPoint
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.Transparent.toArgb(), Color.White.toArgb())
        )
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun LogInScreen(navController: NavController) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

    Image(
        painter = painterResource(R.drawable.login_signup_background),
        contentDescription = "Background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(48.sdp))


        Image(
            painter = painterResource(R.drawable.a2_logo),
            contentDescription = "A2 Logo",
            modifier = Modifier
                .size(36.sdp)
        )

        Spacer(modifier = Modifier.height(12.sdp))

        Text(
            text = "Login To Your Account",
            fontSize = 16.ssp,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(16.sdp))

        // Email OutlinedTextField
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(12.sdp)
        )

        Spacer(modifier = Modifier.height(8.sdp))

        // Password OutlinedTextField
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon"
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(
                        imageVector = if (passwordVisible.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible.value) "Hide Password" else "Show Password"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(0.8f),
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(12.sdp)
        )

        Spacer(modifier = Modifier.height(8.sdp))

        Text(
            text = "or",
            fontSize = 12.ssp,
            fontFamily = FontFamily.Serif,
        )

        Spacer(modifier = Modifier.height(4.sdp))

        Text(
            text = "Continue With",
            fontSize = 16.ssp,
            fontFamily = FontFamily.Serif,
        )

        Spacer(modifier = Modifier.height(16.sdp))

        Box(
            modifier = Modifier
                .height(48.sdp)
                .clip(RoundedCornerShape(12.sdp))
                .background(Color.White)
                .padding(horizontal = 12.sdp),
            contentAlignment = Alignment.Center
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.sdp)
            ){

                Image(
                    painter = painterResource(R.drawable.ic_google_logo),
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(32.sdp)
                )

                Text(
                    text = "Google",
                    fontSize = 18.ssp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.sdp))

        Box(
            modifier = Modifier
                .height(42.sdp)
                .clip(RoundedCornerShape(12.sdp))
                .background(Color.Blue)
                .fillMaxWidth(0.6f)
                .padding(horizontal = 12.sdp)
                .clickable {
                    navController.navigate(Screen.Home.route)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Login",
                fontSize = 18.ssp,
                color = Color.White,
                fontFamily = FontFamily.Serif
            )
        }

        Spacer(modifier = Modifier.height(4.sdp))

        TextButton(
            onClick = {
                navController.navigate(Screen.SignUp.route)
            }
        ) {
            Row{

                Text(
                    text = "Don't have an Account?",
                    fontSize = 12.ssp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Black
                )

                Text(
                    text = " Sign Up",
                    fontSize = 12.ssp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignInPreview(){

    val navController = rememberNavController()
    LogInScreen(navController)

}