package com.ciru.frama.ui.theme.login


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.R
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.Orange

@Composable
fun LoginPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "LOG IN",
                color = Orange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(10.dp))
            LogInDetails()
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(text = "Forgot Password?", color = Color.Blue)
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
                Text(
                    text = "Sign Up",
                    color = Color.Blue
                )
            }
        }
    }
}

@Composable
fun LogInDetails() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
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
                placeholder = { Text(text = "Password")},
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_visibility_off_24),
                            contentDescription = null
                        )
                    }
                }
            )
            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Blue)
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