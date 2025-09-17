package com.example.a2

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.a2.ui.theme.A2Theme
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            A2Theme {
                Navigation()
            }
        }

        retriveToken()
    }

    private fun retriveToken(){
        Firebase.messaging.token.addOnCompleteListener {
            if (it.isSuccessful){
                val token = it.result
                Log.d("FCM token", "retriveToken: $token")
            }
        }
    }
}
