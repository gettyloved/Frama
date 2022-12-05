package com.ciru.frama.ui.theme.cart

import androidx.annotation.DrawableRes

data class CartItems(
    @DrawableRes val image:Int,
    val service:String,
    val qty:String,
    val amount:String
)
