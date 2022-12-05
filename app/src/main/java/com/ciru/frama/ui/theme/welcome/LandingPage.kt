@file:OptIn(ExperimentalPagerApi::class)

package com.ciru.frama.ui.theme.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.ciru.frama.ui.theme.home.HomePage
import com.google.accompanist.pager.*


@Composable
fun LandingPage() {
    val items = listOf(
        LandingInput(
            R.drawable.order,
            "Choose The Service",
            "Get to choose the kind of service that suits your laundry most"
        ),
        LandingInput(
            R.drawable.order,
            "Schedule Pickup",
            "Get your laundry picked at your most convenience without leaving the comfort of your home"
        ),
        LandingInput(
            R.drawable.order,
            "Top Washing Facilities",
            "We are equipped with the best top of the state washing facilities to ensure your clothes are safe with us all the time"
        ),
        LandingInput(
            R.drawable.order,
            "On Time Delivery",
            "Get your laundry delivered to you as soon as they are done cleaning without leaving the house"
        ),
        LandingInput(
            R.drawable.order,
            "Pay Later",
            "You can pay for your laundry once you're satisfied with our services."
        )
    )
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                count = 5,
                state = pagerState
            ) { position ->
                LandingScreen(landingInput = items[position])
            }
            Spacer(modifier = Modifier.padding(10.dp))
            HorizontalPagerIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                pagerState = pagerState,
                activeColor = Orange
            )
            Spacer(modifier = Modifier.padding(10.dp))
            FinishButton(modifier = Modifier,pagerState = pagerState){

            }
        }
    }

}

@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 4
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
                Text(
                    text = "Finish",
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun LandingScreen(landingInput: LandingInput) {
    Column(
        modifier = Modifier
            .padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = landingInput.image),
            contentDescription = null,
            modifier = Modifier.size(400.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = landingInput.title,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Blue,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = landingInput.text
        )
    }
}


@Preview(showBackground = true, )
@Composable
fun LandingPagePreview(){
    LandingPage()
}