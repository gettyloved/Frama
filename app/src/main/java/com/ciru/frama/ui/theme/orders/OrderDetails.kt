package com.ciru.frama.ui.theme.orders

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun OrderDetails() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            OrderIdCard()
            PickUpAddressCard()
            DateAndTimeCard()
            OrderDetailsCard()
        }
    }
}

@Composable
fun OrderIdCard() {
    Card(
        modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Order Id: 123",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$234"
                )
            }
    }
}
}

@Composable
fun PickUpAddressCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Pickup Address",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Utawala, Nairobi"
                )
            }
        }
    }
}

@Composable
fun DateAndTimeCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Pickup Date and Time",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Monday,1/1/2022 09:00hrs"
                )
            }
        }
    }
}

@Composable
fun OrderDetailsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 10.dp
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Order Id: 123",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$234"
                )
            }
        }
    }
}