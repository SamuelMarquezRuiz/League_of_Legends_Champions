package com.example.leagueoflegendschampions.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.leagueoflegendschampions.ChampDetailScreen
import com.example.leagueoflegendschampions.DinamicChampListItem
import com.example.leagueoflegendschampions.ChampRepository

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "champList") {
        composable("champList") {
            DinamicChampListItem(onChampClick = { index ->
                navController.navigate("champDetail/$index")
            })
        }

        composable(
            route = "champDetail/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            val champ = ChampRepository.champs[index]
            ChampDetailScreen(champ = champ, onBack = { navController.popBackStack() })
        }
    }
}
