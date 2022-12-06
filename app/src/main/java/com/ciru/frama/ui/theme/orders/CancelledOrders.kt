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
fun CancelledOrders() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            CancelledOrderBody(
                cancelledOrdersItems = listOf(
                    CancelledOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                    CancelledOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                    CancelledOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                    CancelledOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                    CancelledOrdersItems(
                        "Order Id: 123",
                        "$234"
                    ),
                )
            )
        }
    }
}

@Composable
fun CancelledOrderBody(cancelledOrdersItems:List<CancelledOrdersItems>) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        items(5){
            CancelledOrderCard(cancelledOrdersItems = cancelledOrdersItems[it])
        }
    }
}

@Composable
fun CancelledOrderCard(cancelledOrdersItems: CancelledOrdersItems) {
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
                Text(text = cancelledOrdersItems.orderNo, fontWeight = FontWeight.Bold)
                Text(text = cancelledOrdersItems.amount)
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text(text = "View Details", color = Color.White)
            }
        }
    }
}

@Composable
fun EmptyCancelledOrders() {
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
fun CancelledOrdersPreview(){
    CancelledOrders()
}
