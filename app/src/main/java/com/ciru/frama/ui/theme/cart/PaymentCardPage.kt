package com.ciru.frama.ui.theme.cart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.R
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.LightBlueWhite

@Composable
fun PaymentCardPage() {
    Box(Modifier.fillMaxSize()
    ) {
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(10.dp)
       ) {
          Row(
              modifier = Modifier
                  .fillMaxWidth(),
              horizontalArrangement = Arrangement.Center
          ) {
                Text(
                    text = stringResource(R.string.payment),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
          }
           Spacer(modifier = Modifier.padding(10.dp))
           PaymentMethod()
           Spacer(modifier = Modifier.padding(10.dp))
           CardDetails()
       }
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp).align(Alignment.BottomCenter)) {
            ProceedButton()
        }
    }
}

@Composable
fun PaymentMethod() {
    Column(Modifier.fillMaxWidth()) {
        Text(text = "Total Price")
        Text(
            text = "$530.00",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = BlueWhiteDark
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Payment Method")
        LazyRow(contentPadding = PaddingValues(10.dp)){
            items(8){
                PaymentCard()
            }
        }
    }
}

@Composable
fun PaymentCard() {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
//                will display the type of payment in card details
            },
        elevation = 5.dp,
        backgroundColor = LightBlueWhite
    ) {
//        should fade if not selected
        Text(
            text = "Credit",
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
        )
    }
}

@Composable
fun CardDetails() {
    var cardNumber by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Card Number",
            modifier = Modifier.padding(5.dp)
        )
        TextField(
            value = cardNumber,
            onValueChange = { cardNumber = it},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "**** **** **** ****")}
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                var expiry by remember {
                    mutableStateOf("")
                }
                Text(text = "Valid Until")
                TextField(
                    value = expiry,
                    onValueChange = {expiry = it},
                    placeholder = { Text(text = "Month/Year")}
                )
            }
            Column {
                var expiry by remember {
                    mutableStateOf("")
                }
                Text(text = "CVV")
                TextField(
                    value = expiry,
                    onValueChange = {expiry = it},
                    placeholder = { Text(text = "***")}
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Card Holder")
        TextField(
            value = cardNumber,
            onValueChange = { cardNumber = it},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Card Holder Name")}
        )
    }
}

@Composable
fun ProceedButton() {
    val checked by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Save card for future payments")
        IconToggleButton(
            checked = false,
            onCheckedChange = { checked }
//        above onCheckedChange value is just used as an example. it should be changed
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_toggle_on_24),
                contentDescription = null,
                tint = BlueWhiteDark
            )
        }
    }
    Button(
        onClick = {
//        Make Payment
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            BlueWhiteDark
        )
    ) {
        Text(
            text = "PAY",
            color = Color.White
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    FramaTheme {
        PaymentCardPage()
    }
}