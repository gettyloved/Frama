package com.ciru.frama.ui.theme.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ciru.frama.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.Orange
import com.ciru.frama.ui.theme.navigation.Screen
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun OrderMap(navController: NavController) {
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    var text by remember { mutableStateOf("") }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = singapore),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
    Box (
        modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
    ){
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            leadingIcon = {
              Icon(
                  painter = painterResource(id = R.drawable.ic_baseline_search_24),
                  contentDescription = null,
                  tint = Color.Black
              )
            },
            singleLine = true
        )
        Button(
            onClick = { navController.navigate(Screen.DateTime.route) },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(45.dp),
            colors = ButtonDefaults.buttonColors(Orange)
        ) {
            Text(
                text = "Select Date/Time",
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OrderMapPreview() {
    FramaTheme {
//        OrderMap()
    }
}