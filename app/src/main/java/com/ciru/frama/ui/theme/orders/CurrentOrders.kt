package com.ciru.frama.ui.theme.orders


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CurrentOrders() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            CurrentOrderBody(
                currentOrdersItems = listOf(
                    CurrentOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                    CurrentOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                    CurrentOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                    CurrentOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                    CurrentOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                )
            )
        }
    }
}

@Composable
fun CurrentOrderBody(currentOrdersItems:List<CurrentOrdersItems>) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        items(5){
            CurrentOrderCard(currentOrdersItems = currentOrdersItems[it])
        }
    }
}

@Composable
fun CurrentOrderCard(currentOrdersItems: CurrentOrdersItems) {
    Card(
        modifier = Modifier
            .fillMaxSize()
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
                Text(text = currentOrdersItems.orderNo, fontWeight = FontWeight.Bold)
                Text(text = currentOrdersItems.amount)
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(text = "View Details", color = Color.White)
            }
        }
    }
}

@Composable
fun EmptyCurrentOrders() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "You do not have ongoing orders. Kindly order",
            modifier = Modifier.align(Alignment.Center),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, )
@Composable
fun CurrentOrdersPreview(){
    EmptyCurrentOrders()
}
