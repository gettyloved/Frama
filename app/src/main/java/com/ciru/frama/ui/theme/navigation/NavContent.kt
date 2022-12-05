@file:OptIn(ExperimentalFoundationApi::class)

package com.ciru.frama.ui.theme.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.cart.Cart
import com.ciru.frama.ui.theme.cart.PaymentMethod
import com.ciru.frama.ui.theme.map.OrderMap
import com.ciru.frama.ui.theme.process.DateTime


@ExperimentalFoundationApi
@Composable
fun MainContent(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = Screen.Cart.route
    ){
        composable(route = Screen.Cart.route){
            Cart(navController = navController)
        }
        composable(route = Screen.PaymentMethod.route){
            PaymentMethod(navController = navController)
        }
        composable(route = Screen.DateTime.route){
            DateTime(navController = navController)
        }
        composable(route = Screen.Map.route){
            OrderMap(navController = navController)
        }
    }
}

@Preview()
@Composable
fun NavPreview() {
    FramaTheme {
        MainContent(navController = rememberNavController())
    }
}