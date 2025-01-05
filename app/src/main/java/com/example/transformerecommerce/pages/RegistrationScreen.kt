package com.example.transformerecommerce.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.transformerecommerce.navigation.LOGIN_URL
import com.example.transformerecommerce.navigation.REGISTER_URL

import org.w3c.dom.Text

@Composable
fun RegistrationScreen(navController:NavHostController){
    Column(modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier=Modifier.height(50.dp))

        var name by remember { mutableStateOf("")}
        var email by remember { mutableStateOf("")}
        var password by remember { mutableStateOf("")}

        OutlinedTextField(

            value = name,
            onValueChange = {name = it},
          label = { Text(text = "Enter name...")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)

        )

        Spacer(modifier=Modifier.height(50.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text(text = "Enter email...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier=Modifier.height(50.dp))
        OutlinedTextField(

            value = password,
            onValueChange = {password = it},
            label = {Text(text = "Enter email...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier=Modifier.height(50.dp))
        Button(onClick = {}) {
            Text(text="Register")
        }

        Spacer(modifier=Modifier.height(50.dp))
        Button(onClick = {
            navController.navigate(LOGIN_URL)
        }) {
            Text(text="Login")
        }

    }

}