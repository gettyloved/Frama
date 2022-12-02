package com.ciru.frama.ui.screens.orders

import androidx.annotation.DrawableRes

data class CurrentOrderItems(
    @DrawableRes val image:Int,
    var service:String,
    var time:Int,
    var amount:Int
)
