package com.example.transformerecommerce.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.transformerecommerce.data.ProductsRepository
import com.example.transformerecommerce.models.Product

@Composable
fun ViewProductsScreen(navController: NavHostController){
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment=Alignment.CenterHorizontally){
        val context = LocalContext.current
        val productRepository = ProductsRepository(navController, context)


        var emptyProductState = remember { mutableStateOf(Product("","","","","")) }
        var emptyProductListState = remember { mutableStateListOf<Product>() }
        var products = productRepository.viewProduct(emptyProductState,emptyProductListState)
        Text(text = "All products")
        Spacer(modifier=Modifier.height(20.dp))
        LazyColumn{
            items(product){
                ProductItem(name = it.name, quantity = it.quantity, price = it.price, id = it.id, image = it.imageUrl, productRepository = productRepository, navController = navController)
            }
        }
    }

}
@Composable
fun ProductItem(
    name: String,
    quantity: String,
    price: String,
    id: String,
    productsRepository: ProductsRepository,
    navController: NavHostController,
    image: Any,
    productRepository: ProductsRepository
){
    Column (modifier = Modifier.fillMaxSize()){
        Text(text = name)
        Text(text = quantity)
        Text(text = price)
        Image(
            painter= rememberAsyncImagePainter(image)
            contentDescription="Product image"
           modifier=Modifier.size(250.dp)
        )
        Button(onClick = {
            productsRepository.deleteProduct(id)
        }) {
            Text(text="Delete")
        }
        Button(onClick = {}) {
            Text(text = "Update")
        }
    }
}

