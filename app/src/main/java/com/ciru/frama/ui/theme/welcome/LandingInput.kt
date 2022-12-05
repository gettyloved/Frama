package com.ciru.frama.ui.theme.welcome

import androidx.annotation.DrawableRes

data class LandingInput(
    @DrawableRes val image:Int,
    val title:String,
    val text:String
)
