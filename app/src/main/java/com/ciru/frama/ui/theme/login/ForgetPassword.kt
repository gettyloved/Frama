package com.ciru.frama.ui.theme.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.Orange

@Composable
fun ForgetPassword() {
    Box(modifier = Modifier.fillMaxSize()) {
        var email by remember { mutableStateOf("") }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Reset Password",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Card(
                elevation = 10.dp, 
                modifier = Modifier.padding(horizontal = 10.dp).align(CenterHorizontally)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                   Text(text = "Enter Email to get reset password code")
                    Spacer(modifier = Modifier.padding(10.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = {email = it},
                        placeholder = { Text(text = "Enter Email")}
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Orange)
                    ) {
                       Text(text = "Enter", color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ForgetPreview() {
    FramaTheme {
        ForgetPassword()
    }
}