package com.ciru.frama.ui.theme.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AdminLogin() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
           Text(
               text = "Admin Login",
               fontWeight = FontWeight.Bold,
           )
            Spacer(modifier = Modifier.padding(10.dp))
//            EmailTextField(
//                onValueChange =
//            )
//            PasswordTextField(
//                onValueChange =
//            )
//            Spacer(modifier = Modifier.padding(20.dp))
//            FramaProceedButton(
//                onClick =
//            )
//            Spacer(modifier = Modifier.padding(10.dp))
//            Text(
//                text = "Do you have account? SignUp",
//                style = MaterialTheme.typography.bodyMedium,
//                modifier = Modifier.clickable ( onClick = )
//            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewLoginScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        AdminLogin()
    }
}