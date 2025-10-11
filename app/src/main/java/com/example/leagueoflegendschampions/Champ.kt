package com.example.leagueoflegendschampions

import androidx.annotation.DrawableRes

data class Champ(
    @DrawableRes val image: Int,
    val name: String,
    val description: String,
    val lore: String
)
