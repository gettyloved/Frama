package com.ciru.frama.ui.theme.welcome


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.R

@Composable
fun Facilities() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .align(Alignment.Center)
        ) {
            FacilityDetails()
        }
    }
}

@Composable
fun FacilityDetails() {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(id = R.drawable.order),
            contentDescription = "Place Order",
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Get Top Washing Facilities", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Wash It Laundry Service app UI Kit comes with an option to showcase type of services, place order and track order progress interface, with nice details and textures. It’s covers all common Laundry…\n" +
                    "More",
            modifier = Modifier.padding(horizontal = 30.dp)
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Button(
            onClick = {

            },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = "Skip", fontSize = 15.sp)
        }
    }
}


@Preview(showSystemUi=true, showBackground = true, )
@Composable
fun FacilityPreview(){
    FacilityDetails()
}