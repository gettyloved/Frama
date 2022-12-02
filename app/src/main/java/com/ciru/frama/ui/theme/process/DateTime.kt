package com.ciru.frama.ui.theme.process

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme

@Composable
fun DateTime() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(text = "Select Your Schedule", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Spacer(modifier = Modifier.padding(10.dp))
           PickUpDateNTime()
           DeliveryDateNTime()
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(BlueWhiteDark)
            ) {
                Text(text = "Continue to Payment", color = Color.White)
            }
        }
    }
}

@Composable
fun PickUpDateNTime() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "PickUp Date",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "November 2022"
//            should show the appropriate month and the year
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        LazyRow(
            contentPadding = PaddingValues(10.dp)
        ){
            items(10){
                PickUpDateCard()
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Pickup Time", fontWeight = FontWeight.Bold)
        LazyRow(
            contentPadding = PaddingValues(10.dp)
        ){
            items(10){
                PickUpTimeCard()
            }
        }
    }
}

@Composable
fun PickUpTimeCard() {
    Card(
        elevation = 10.dp,
        modifier = Modifier.padding(10.dp)
    ) {
       Row(
           horizontalArrangement = Arrangement.Center,
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier.padding(horizontal = 10.dp)
       ){
           Text(text = "0800 hrs - 1000 hrs", fontWeight = FontWeight.Bold)
       }
    }
}

@Composable
fun PickUpDateCard() {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
    ) {
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier.padding(horizontal = 10.dp)
       ) {
           Text(text ="9" , fontWeight = FontWeight.Bold)
           Text(text ="Fri" , fontWeight = FontWeight.Bold)
       }
    }
}


@Composable
fun DeliveryDateNTime() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "PickUp Date",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "November 2022"
//            should show the appropriate month and the year
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        LazyRow(
            contentPadding = PaddingValues(10.dp)
        ){
            items(10){
                DeliveryDateCard()
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Pickup Time", fontWeight = FontWeight.Bold)
        LazyRow(
            contentPadding = PaddingValues(10.dp)
        ){
            items(10){
                DeliveryTimeCard()
            }
        }
    }
}

@Composable
fun DeliveryTimeCard() {
    Card(
        elevation = 10.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "0800 hrs - 1000 hrs", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DeliveryDateCard() {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .wrapContentSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text ="9" , fontWeight = FontWeight.Bold)
            Text(text ="Fri" , fontWeight = FontWeight.Bold)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DatePagePreview() {
    FramaTheme {
        DateTime()
    }
}