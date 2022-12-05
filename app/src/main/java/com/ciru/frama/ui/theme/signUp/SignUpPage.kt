package com.ciru.frama.ui.theme.signUp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.Orange

@Composable
fun SignUpPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "SIGN UP",
            color = Orange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            UserDetails()
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {
            Text(text = "Already have an account?")
            TextButton(
                onClick = {  }
            ) {
                Text(text = "LogIn", color = Orange)
            }
        }
    }
}

@Composable
fun UserDetails() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .wrapContentSize()
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email")}
            )
            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Password")}
            )
            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(text = "Sign Up", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    FramaTheme {
        SignUpPage()
    }
}