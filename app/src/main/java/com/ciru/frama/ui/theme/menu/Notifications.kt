package com.ciru.frama.ui.theme.menu



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.R
import com.ciru.frama.ui.theme.FramaTheme

@Composable
fun NotificationsPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
               Text(text = "Notifications", fontWeight = FontWeight.Bold) 
            }
            Spacer(modifier = Modifier.padding(10.dp))
            NotificationsInfo()
        }
    }
}

@Composable
fun NotificationsInfo() {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(9){
            NotificationsCard()
        }
    }
}

@Composable
fun NotificationsCard() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_cancel_24),
                contentDescription = "Cancelled"
            )
            Column {
                Text(
                    text = "Cancelled Order",
                    fontWeight = FontWeight.Bold
                )
                Text(text = "You've successfully cancelled your order")
            }
            Text(
                text = "09 Nov",
                fontSize = 10.sp
            )
        }
        Divider(thickness = 1.dp, color = Color.Black)
    }
}


@Preview(showBackground = true)
@Composable
fun NotificationsPagePreview() {
    FramaTheme {
       NotificationsPage()
    }
}
