package com.ciru.frama.ui.theme.login


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme

@Composable
fun LoginPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            LogInDetails()
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Forgot Password?")
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {
            Text(text = "No account?")
            TextButton(
                onClick = {  }
            ) {
                Text(text = "Sign Up")
            }
        }
    }
}

@Composable
fun LogInDetails() {
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
                colors = ButtonDefaults.buttonColors(BlueWhiteDark)
            ) {
                Text(text = "Log In", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LogInPreview() {
    FramaTheme {
        LoginPage()
    }
}