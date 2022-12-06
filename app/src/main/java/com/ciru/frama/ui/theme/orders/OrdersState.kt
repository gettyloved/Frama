package com.ciru.frama.ui.theme.orders

import androidx.compose.runtime.Immutable


@Immutable
data class OrdersState(val isLoading:Boolean,
val isEmpty:Boolean?){
    companion object{
        val Default = OrdersState(isLoading = false,
        isEmpty = true)
    }
}