package com.ciru.frama.ui.theme.orders

import androidx.compose.runtime.Composable


typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    val title:String,
    val pages:ComposableFun
){
   object CurrentOrders:TabItem("Current Orders",  pages = { CurrentOrders() })
   object PastOrders:TabItem("Past Orders",  pages = { PastOrders()})
   object CancelledOrders:TabItem("Cancelled Orders",  pages = { CancelledOrders()})
}
