@file:OptIn(ExperimentalMaterialApi::class, ExperimentalUnitApi::class)

package com.ciru.frama.ui.theme.menu



import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.ciru.frama.R
import com.ciru.frama.ui.theme.FramaTheme

@Composable
fun NotificationsPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
               Text(text = "Notifications", fontWeight = FontWeight.Bold) 
            }
            Spacer(modifier = Modifier.padding(10.dp))
            NotificationsInfo(noteList = listOf())
        }
    }
}

@Composable
fun NotificationsInfo(
    noteList: List<NoteList>
) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(noteList.size) {
            NotificationsCard(noteList[it])
        }
    }
}



@Composable
fun NotificationsCard(noteList: NoteList) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                painter = painterResource(id = noteList.image),
                contentDescription = "Cancelled"
            )
            Column {
                Text(
                    text = noteList.title,
                    fontWeight = FontWeight.Bold
                )
                Text(text = noteList.text)
            }
            Text(
                text = noteList.date,
                fontSize = 10.sp
            )
        }
        Divider(thickness = 1.dp, color = Color.Black)
    }
}

@Composable
fun EmptyNotification() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "You do not have notifications",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NotificationsPagePreview() {
    FramaTheme {
       EmptyNotification()
    }
}
