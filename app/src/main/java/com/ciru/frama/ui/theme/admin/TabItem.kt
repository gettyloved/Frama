package com.ciru.frama.ui.screens.admin

import androidx.compose.runtime.Composable
import com.ciru.frama.ui.theme.admin.ItemsDelivered
import com.ciru.frama.ui.theme.admin.ItemsOrdered


typealias ComposableFun = @Composable () -> Unit
sealed class TabItem(
    val title:String,
    val pages:ComposableFun
){
    object Ordered:TabItem("Order", pages = { ItemsOrdered() })
    object Deliverd:TabItem("Deliver", pages = { ItemsDelivered() })
}
