package com.example.transformerecommerce.pages

import android.content.Context
import android.media.Image
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.contracts.contract

@Composable
fun AddProductsScreen(navContrroller: NavHostController){
    Column (modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){  }
    Spacer(modifier= Modifier.height(50.dp))
    Text(
        text="Add products",
        fontSize = 40.sp
    )
    Spacer(modifier= Modifier.height(20.dp))
    var productName by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    val context= LocalContext.current
    Spacer(modifier = Modifier.height(30.dp))
    OutlinedTextField(
        value=productName,
        onValueChange = {productName=it},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text="Enter product name...")}
    )
    Spacer(modifier=Modifier.height(30.dp))
    OutlinedTextField(
        value = productQuantity,
        onValueChange = {productQuantity=it},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = {Text(text="Enter product quantity....")}
    )

    Spacer(modifier=Modifier.height(30.dp))
    OutlinedTextField(
        value = productPrice,
        onValueChange = {productPrice=it},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = {Text(text="Enter product price....")}
    )
    Spacer(modifier=Modifier.height(30.dp))
    ImagePicker(context,navContrroller,productName,productQuantity,productPrice)

}



@Composable
fun ImagePicker(context: Context, navController:NavHostController, name:String, quantity:String, price:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    var imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }

    )
    Column {

        if (hasImage && imageUri != null){
            val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(modifier = Modifier.fillMaxWidth(),

            horizontalAlignment = Alignment.CenterHorizontally) {

            Button(onClick = {

                imagePicker.launch("image/*")

            }) {

                Text(text = "Select image")

            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = {}) {

                Text(text = "Upload")

            }

        }

    }

    }
