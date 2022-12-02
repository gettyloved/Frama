package com.ciru.frama.ui.theme.orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.CardDefaults
import com.ciru.frama.ui.screens.orders.HistoryItems
import com.ciru.frama.ui.theme.LightBlueWhite
import java.util.*

@Composable
fun History() {
    Text(
        text = "You don't have any orders yet. Kindly place your order.",
        color = Color.Gray,
        fontSize = 30.sp
    )
    HistoryBody(historyItems = listOf())
}


@Composable
fun HistoryBody(historyItems: List<HistoryItems>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)){
        items(historyItems.size){
            HistoryData(historyItems = historyItems[it])
        }
    }
}


@Composable
fun HistoryData(historyItems: HistoryItems) {
    Card(
        elevation = 6.dp,
        modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(LightBlueWhite)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Image(
                painter = painterResource(id = historyItems.image),
                contentDescription = "Service ordered"
            )
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = historyItems.service
                )
                Text(
                    text = historyItems.time.toString()
                )
            }
            Text(
                text = historyItems.amount.toString()
            )
        }
    }
}