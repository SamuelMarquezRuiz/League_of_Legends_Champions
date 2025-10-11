package com.example.leagueoflegendschampions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.leagueoflegendschampions.navigation.AppNav
import com.example.leagueoflegendschampions.ui.theme.LeagueOfLegendsChampionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LeagueOfLegendsChampionsTheme {
                AppNav()
            }
        }
    }
}
