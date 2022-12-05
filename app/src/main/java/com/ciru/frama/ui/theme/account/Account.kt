package com.ciru.frama.ui.theme.account


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.R
import com.ciru.frama.ui.theme.BlueWhite
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.LightBlueWhite

@Composable
fun AccountPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            NameColumn()
            Spacer(modifier = Modifier.padding(30.dp))
            BasicInfo()
            Spacer(modifier = Modifier.padding(20.dp))
            SecurityInfo()
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(BlueWhiteDark)
        ) {
           Text(text = "Log Out", color = Color.White)
        }
    }
}

@Composable
fun NameColumn() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
                .background(BlueWhite)) {
                Text(
                    text = "G",
                    color = Color.White,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.Center),
                    fontSize = 30.sp
                )
            }
            Text(text = "Gibson Ruitiari")
            Text(text = "gibsonruitiari@gmail.com")
        }
    }
}

@Composable
fun BasicInfo() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 5.dp
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Basic Info", fontWeight = FontWeight.Bold)
                IconButton(
                    onClick = { 
//                      edit info
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_edit_24 ), 
                        contentDescription = "Edit Profile")
                }
            }
            Text(text = "NAME")
            Text(text = "Gibson Ruitiari")
            Text(text = "EMAIL")
            Text(text = "gibsonruitiari@gmail.com")
        }
    }
}

@Composable
fun SecurityInfo() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
           Row(
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically,
               modifier = Modifier.fillMaxWidth()
           ) {
               Text(text = "Security Info")
               IconButton(
                   onClick = {
//                      edit info
                   }
               ) {
                   Icon(
                       painter = painterResource(id = R.drawable.ic_baseline_edit_24 ),
                       contentDescription = "Edit Profile")
               }
           } 
            Text(text = "PASSWORD")
            Text(text = "****")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AccountPreview() {
    FramaTheme {
        AccountPage()
    }
}