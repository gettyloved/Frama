package com.ciru.frama.ui.theme.signUp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.Orange

@Composable
fun SignUpWelcomePage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Frama",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "How would you like to continue?")
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
               Text(text = "Sign Up", color = Color.White)
            }
            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
                Text(text = "Continue Anonymously", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpWelcomePreview() {
    FramaTheme {
        SignUpWelcomePage()
    }
}