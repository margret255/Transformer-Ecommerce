package com.example.transformerecommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.transformerecommerce.ui.theme.TransformerEcommerceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransformerEcommerceTheme {

            }
        }
    }
}

// RegistrationScreen

       // Variables= - name, email, password
        // Buttons= - Register - Login

// LoginScreen

    // Variables=- email, password
   // Buttons= - Login - Register

// HomeScreen

// - Welcome message text

