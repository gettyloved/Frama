package com.ciru.frama.ui.theme.process

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.R
import com.ciru.frama.ui.theme.Orange

@Composable
fun DescriptionPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Text(
                text = "Title",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                color = Color.Blue
            )
            Spacer(modifier = Modifier.padding(15.dp))
            Image(
                painter = painterResource(id = R.drawable.tshirt),
                contentDescription = "item Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "$200",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Orange
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Wash It Laundry Service app UI Kit comes with an option to showcase type of services, place order and track order progress interface, with nice d"
            )
        }
    }
}


@Preview( showBackground = true, )
@Composable
fun DescriptionPagePreview(){
    DescriptionPage()
}