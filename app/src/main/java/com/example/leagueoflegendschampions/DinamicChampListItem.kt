package com.example.leagueoflegendschampions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Divider

@Composable
fun DinamicChampListItem(onChampClick: (Int) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "League of Legends Champions",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )
        LazyColumn {
            itemsIndexed(ChampRepository.champs) { index, champ ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onChampClick(index) }
                        .background(Color.White)
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(champ.image),
                        contentDescription = "Champion Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(60.dp)
                            .clip(CircleShape)
                    )
                    Column {
                        Text(text = champ.name, style = MaterialTheme.typography.titleLarge)
                        Text(text = champ.description, style = MaterialTheme.typography.bodyLarge)
                    }
                }
                Divider(
                    color = Color.Gray.copy(alpha = 0.5f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}
