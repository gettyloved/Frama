package com.ciru.frama.ui.theme.account


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.R
import com.ciru.frama.ui.theme.FramaTheme
import com.ciru.frama.ui.theme.menu.NoteList
import com.ciru.frama.ui.theme.menu.swipeToDismiss

@Composable
fun InboxPage() {
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
                Text(text = "Input", fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            InboxInfo(
                noteList = listOf(
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                    NoteList(
                        R.drawable.ic_baseline_remove_circle_outline_24,
                        "Cancelling Order",
                        "your order has been cancelled successfully",
                        "9 Nov"
                    ),
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InboxInfo(noteList:List<NoteList>) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(noteList.size){
           InboxCard(noteList = noteList[it])
        }
    }
}

@Composable
fun InboxCard(noteList: NoteList) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), elevation = 10.dp) {
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
    }

//    Column(
//        ,
//        verticalArrangement = Arrangement.spacedBy(15.dp)
//    ) {
//
//        Divider(thickness = 1.dp, color = Color.Black)
//    }
}

@Composable
fun EmptyInbox() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "You do not have notifications",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun InboxPagePreview() {
    FramaTheme {
        InboxPage()
    }
}
