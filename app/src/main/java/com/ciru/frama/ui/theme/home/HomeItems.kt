package com.ciru.frama.ui.theme.home

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp

data class HomeItems(
    @DrawableRes val image:Int,
    val title:String,
    val subTitle:String,
    val size: Dp
)
