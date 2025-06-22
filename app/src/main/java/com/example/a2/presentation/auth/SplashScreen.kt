package com.example.a2.presentation.auth

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.a2.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }
}

@Composable
fun SplashScreen() {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(2500)
        context.startActivity(Intent(context, StartActivity::class.java))
        if(context is Activity){
            context.finish()
        }
    }

    Image(
        painter = painterResource(id = R.drawable.start_activity_img),
        contentDescription = "logo",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Column(

        ) {
            Image(
                painter = painterResource(R.drawable.a2_logo),
                contentDescription = "A2 Logo",
                modifier = Modifier
                    .padding(horizontal = 16.sdp, vertical = 8.sdp)
                    .size(28.sdp)
            )

            Text(
                text = "Nourish your\ninner skills",
                fontSize = 26.ssp,
                modifier = Modifier
                    .padding(horizontal = 16.sdp),
                fontFamily = FontFamily.Serif
            )

            Spacer(modifier = Modifier.height(4.sdp))

            Text(
                text = "Your AI learning journey\nbegins here",
                fontSize = 13.ssp,
                modifier = Modifier
                    .padding(horizontal = 16.sdp)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.learning_img),
                contentDescription = "Learning image",
                modifier = Modifier.size(200.sdp)
            )
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashPreview() {
    SplashScreen()
}
