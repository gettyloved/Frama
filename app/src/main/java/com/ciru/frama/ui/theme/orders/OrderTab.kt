package com.ciru.frama.ui.screens.orders

import androidx.compose.runtime.Composable
import com.ciru.frama.ui.theme.orders.CurrentOrders
import com.ciru.frama.ui.theme.orders.History

typealias ComposableFun = @Composable ()-> Unit

sealed class OrderTab(
    val title:String,
    val pages:ComposableFun
){
    object CurrentOrders:OrderTab("CurrentOrders", pages = { CurrentOrders() })
    object History:OrderTab("History", { History() })
}
