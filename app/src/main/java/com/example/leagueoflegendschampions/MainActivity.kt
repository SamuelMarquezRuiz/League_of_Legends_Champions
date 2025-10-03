package com.example.leagueoflegendschampions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.leagueoflegendschampions.ui.theme.LeagueOfLegendsChampionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeagueOfLegendsChampionsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Column(
                        modifier = Modifier.padding(padding)
                    ) {
                        DinamicChampListItem();
                    }
                }
            }
        }
    }
}

data class Champ(val image: Int, val name: String, val description: String)

@Composable
fun ChampListItem(champ: Champ) {
    val imageModifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp).size(40.dp).clip(
        CircleShape
    )
    Row(
        modifier = Modifier.fillMaxWidth().background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = imageModifier,
            painter = painterResource(champ.image),
            contentDescription = "Champion Image",
            contentScale = ContentScale.Crop
        )
        Column (
            modifier = Modifier.padding(vertical = 8.dp)
        ){
            Text(text=champ.name,
                style = MaterialTheme.typography.titleLarge)
            Text(text=champ.description,
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun DinamicChampListItem() {
    val dinamicChampList: List<Champ> = listOf(
        Champ(image = R.drawable.annie, name = "Annie", description = "The Dark Child"),
        Champ(image = R.drawable.diana, name = "Diana", description = "Scorn of the Moon"),
        Champ(image = R.drawable.fizz, name = "Fizz", description = "The Tidal Trickster"),
        Champ(image = R.drawable.irelia, name = "Irelia", description = "The Blade Dancer"),
        Champ(image = R.drawable.leona, name = "Leona", description = "The Radiant Dawn"),
        Champ(image = R.drawable.mordekaiser, name = "Mordekaiser", description = "The Iron Revenant"),
        Champ(image = R.drawable.neeko, name = "Neeko", description = "The Curious Chameleon"),
        Champ(image = R.drawable.senna, name = "Senna", description = "The Redeemer"),
        Champ(image = R.drawable.taric, name = "Taric", description = "The Shield of Valoran"),
        Champ(image = R.drawable.teemo, name = "Teemo", description = "The Swift Scout"),
        Champ(image = R.drawable.vi, name = "Vi", description = "The Piltover Enforcer"),
        Champ(image = R.drawable.ziggs, name = "Ziggs", description = "The Hexplosives Expert")
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "League of Legends Champions",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )
        LazyColumn() {
        items(dinamicChampList) { champ ->
            ChampListItem(champ)
            androidx.compose.material3.Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        }
    }
}