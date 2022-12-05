package com.ciru.frama.ui.theme.menu

import androidx.annotation.DrawableRes

data class NoteList(
    @DrawableRes val image:Int,
    val title:String,
    val text:String,
    val date:String
)
