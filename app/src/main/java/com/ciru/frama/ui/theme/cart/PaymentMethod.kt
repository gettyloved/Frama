package com.ciru.frama.ui.theme.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.Orange

@Composable
fun PaymentMethod(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Confirm Order",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(10.dp))
            PayCard()
            Spacer(modifier = Modifier.padding(10.dp))
            AddressCard()
            Spacer(modifier = Modifier.padding(10.dp))
            PickUpDateAndTime()
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(Orange)
        ) {
            Text(text = "Confirm Order", color = Color.White)
        }
    }
}

@Composable
fun PayCard() {
    var checked by remember { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        elevation = 10.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = {checked=it},
                colors = CheckboxDefaults.colors(Orange)
            )
            Text(
                text = "Paypal",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun AddressCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        elevation = 10.dp
    ) {
        Column (modifier = Modifier.padding(15.dp)){
            Text(
                text = "Pickup Address",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Nairobi"
            )
        }
    }
}

@Composable
fun PickUpDateAndTime() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = "Pickup Date and Time",
                fontWeight = FontWeight.Bold
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Date")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Time")
            }
        }
    }
}

@Composable
fun EmptyOrder() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "You have not placed any order.Please Select Order",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    FramaTheme {
//        PaymentMethod()
    }
}