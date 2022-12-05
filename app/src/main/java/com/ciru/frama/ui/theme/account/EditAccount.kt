package com.ciru.frama.ui.theme.account

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
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.Orange

@Composable
fun EditAccount() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            var email by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            var passwordVisibility: Boolean by remember { mutableStateOf(false) }
            Text(
                text = "Edit Account",
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(20.dp))
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Email")}
            )
            Spacer(modifier = Modifier.padding(5.dp))
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
            Spacer(modifier = Modifier.padding(5.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
                Text(
                    text = "Save",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditAccountPreview() {
    FramaTheme {
        EditAccount()
    }
}