package com.ciru.frama.ui.theme.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.R
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.LightBlueWhite
import com.ciru.frama.ui.theme.Orange

@Composable
fun Cart() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            CartHeading()
            Spacer(modifier = Modifier.padding(10.dp))
            OrderItems(cartItems = listOf(
                CartItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "15",
                    "$200"
                ),
                CartItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "15",
                    "$200"
                ),
                CartItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "15",
                    "$200"
                )
            ))
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        ) {
            TotalSection()
        }
    }
}

@Composable
fun CartHeading() {
    Row(
       verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.cart_heading),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Orange
        )
    }
}


@Composable
fun OrderItems(cartItems:List<CartItems>) {
    LazyColumn(
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        items(cartItems.size){
            OrderItem(cartItems = cartItems[it])
        }
    }
}

@Composable
fun OrderItem(cartItems: CartItems) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .clickable {
//                       will lead to item description page
            },
        backgroundColor = LightBlueWhite,
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = cartItems.image),
                contentDescription = "Item selected",
                modifier = Modifier
                    .size(100.dp),
            )
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
               Text(
                   text = cartItems.service,
                   fontWeight = FontWeight.Bold
               )
                Text(
                    text = cartItems.qty,
                    fontWeight = FontWeight.Bold
//                  Number of ItemSelected
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = cartItems.amount,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(
                onClick = {
//                Removes item from the cart
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_remove_circle_outline_24),
                    contentDescription = "Remove Item",
                    tint = BlueWhiteDark
                )
            }
        }
    }
}

@Composable
fun TotalSection() {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.total),
                fontSize = 30.sp
            )
            Text(
                text = "$400",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.subTotal),
                fontSize = 20.sp
            )
            Text(
                text = "$40",
                fontSize = 20.sp,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.tax),
                fontSize = 20.sp
            )
            Text(
                text = "$50",
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = {
//                checks out. goes to the payment method
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Orange
            )
        ) {
            Text(
                text = "Schedule Pickup",
                color = Color.White
            )
        }
    }
}

@Preview()
@Composable
fun CartPreview() {
    FramaTheme {
        Cart()
    }
}