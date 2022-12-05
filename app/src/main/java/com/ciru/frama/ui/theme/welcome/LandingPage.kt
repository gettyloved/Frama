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
            "Choose Your Clothes",
            "Wash It Laundry Service app UI Kit comes with an option to showcase type of services, place order and track order progress interface, with nice d Read More"
        ),
        LandingInput(
            R.drawable.order,
            "Schedule Pickup",
            "Wash It Laundry Service app UI Kit comes with an option to showcase type of services, place order and track order progress interface, with nice d Read More"
        ),
        LandingInput(
            R.drawable.order,
            "Get Top Washing Facilities",
            "Wash It Laundry Service app UI Kit comes with an option to showcase type of services, place order and track order progress interface, with nice d Read More"
        ),
        LandingInput(
            R.drawable.order,
            "Get On Time Delivery",
            "Wash It Laundry Service app UI Kit comes with an option to showcase type of services, place order and track order progress interface, with nice d Read More"
        ),
        LandingInput(
            R.drawable.order,
            "Pay Later",
            "Wash It Laundry Service app UI Kit comes with an option to showcase type of services, place order and track order progress interface, with nice d Read More"
        )
    )


    val pagerState = rememberPagerState()
    
    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = 5,
            state = pagerState
        ) { position ->
            LandingScreen(landingInput = items[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = Orange
        )
        FinishButton(modifier = Modifier,pagerState = pagerState){

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
            .fillMaxSize()
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