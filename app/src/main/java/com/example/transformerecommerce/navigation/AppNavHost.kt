package com.example.transformerecommerce.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.transformerecommerce.pages.HomeScreen
import com.example.transformerecommerce.pages.LoginScreen
import com.example.transformerecommerce.pages.RegistrationScreen
import androidx.navigation.compose.composable
import com.example.transformerecommerce.pages.AddProductsScreen
import com.example.transformerecommerce.pages.ViewProductsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = LOGIN_URL // No change here
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(HOME_URL) {
            HomeScreen(navHostController)
        }
        composable(REGISTER_URL) {
            RegistrationScreen(navHostController)
        }
        composable(LOGIN_URL) {
            LoginScreen(navHostController)
        }
        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navHostController)

        }
        composable(VIEW_PRODUCTS_URL) {
            ViewProductsScreen(navHostController)
        }
    }
}

