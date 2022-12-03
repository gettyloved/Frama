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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.ui.screens.orders.CurrentOrderItems
import com.ciru.frama.ui.theme.LightBlueWhite
import com.ciru.frama.ui.theme.home.HomePage

@Composable
fun CurrentOrders() {
    Text(
        text = "You don't have any orders yet. Kindly place your order.",
        color = Color.Gray,
        fontSize = 30.sp
    )
    CurrentOrderBody(currentOrderItems = listOf())
}

@Composable
fun CurrentOrderBody(currentOrderItems: List<CurrentOrderItems>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)){
        items(currentOrderItems.size){
            CurrentOrderData(currentOrderItems = currentOrderItems[it])
        }
    }
}

@Composable
fun CurrentOrderData(currentOrderItems: CurrentOrderItems) {
        Card(
        elevation = 6.dp,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(LightBlueWhite)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Image(
                painter = painterResource(id = currentOrderItems.image),
                contentDescription = "Service ordered"
            )
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = currentOrderItems.service
                )
                Text(
                    text = currentOrderItems.time.toString()
                )
            }
            Text(
                text = currentOrderItems.amount.toString()
            )
        }
    }
}

@Preview(showSystemUi=true, showBackground = true, )
@Composable
fun OrdersPreview(){
    CurrentOrders()
}