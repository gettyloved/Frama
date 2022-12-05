package com.ciru.frama.ui.theme.process

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ciru.frama.R
import com.ciru.frama.ui.theme.BlueWhiteDark
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.Orange
import com.ciru.frama.ui.theme.navigation.Screen
import java.time.LocalDateTime
import java.util.*

@Composable
fun DateTime(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Select Your Schedule",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 90.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .align(Center),
            verticalArrangement = Arrangement.Center
        ) {
            PickUpDateCard()
            Spacer(modifier = Modifier.padding(10.dp))
            PickUpTimeCard()
        }

        Button(
            onClick = { navController.navigate(Screen.PaymentMethod.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = "Continue to Payment", color = Color.White)
        }
    }
}


@Composable
fun PickUpTimeCard() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)


    val time = remember { mutableStateOf("") }
    val mTimePickerDialog = TimePickerDialog(
        context,
        {_, mHour : Int, mMinute: Int ->
            time.value = "$mHour:$mMinute"
        }, hour, minute, false
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { mTimePickerDialog.show()},
            colors = ButtonDefaults.buttonColors(backgroundColor = Orange),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Pickup Time", color = Color.White)
        }
//        Text(text = "$time")
    }

}

@Composable
fun PickUpDateCard() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            date.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, year, month, day
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { mDatePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Orange),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Pickup Date", color = Color.White)
        }
//        Text(text = "$date")
    }
}



@Preview(showBackground = true)
@Composable
fun DatePagePreview() {
    FramaTheme {
//        DateTime(navController = remb)
    }
}

