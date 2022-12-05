package com.ciru.frama.ui.theme.navigation

sealed class Screen(val route:String) {
    object Cart : Screen(route = "cart")
    object Map : Screen(route = "map")
    object DateTime : Screen(route = "dateTime")
    object PaymentMethod : Screen(route = "paymentMethod")
}
