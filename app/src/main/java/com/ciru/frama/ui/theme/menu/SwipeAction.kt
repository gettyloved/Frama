package com.ciru.frama.ui.theme.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ciru.frama.ui.theme.account.InboxCard
import com.ciru.frama.ui.theme.account.InboxInfo
import com.ciru.frama.ui.theme.account.InboxPage

@ExperimentalMaterialApi
@Composable
fun swipeToDismiss() {
    val dismissState = rememberDismissState(initialValue = DismissValue.Default)


    SwipeToDismiss(
        state = dismissState,
        /***  create dismiss alert Background */
        background = {
            val color = when (dismissState.dismissDirection) {
                DismissDirection.StartToEnd -> Color.Green
                DismissDirection.EndToStart -> Color.Red
                null -> Color.Transparent
            }
            val direction = dismissState.dismissDirection

            if (direction == DismissDirection.StartToEnd) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color)
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.align(Alignment.CenterStart)) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = "Move to Archive", fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }

                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color)
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.align(Alignment.CenterEnd)) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.heightIn(5.dp))
                        Text(
                            text = "Move to Bin",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.LightGray
                        )

                    }
                }
            }
        },
        /**** Dismiss Content */
        dismissContent = {
            InboxInfo(noteList = listOf())
        },
        /*** Set Direction to dismiss */
        directions = setOf(DismissDirection.EndToStart, DismissDirection.StartToEnd),
    )
}