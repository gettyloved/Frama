@file:OptIn(ExperimentalMaterialApi::class)

package com.ciru.frama.ui.theme.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciru.frama.ui.screens.admin.AdminItems

@Composable
fun ItemsOrdered() {
    Column(modifier = Modifier.fillMaxSize()) {
        Item(
            adminItems = listOf(
                AdminItems(
                    "Getty Ciru",
                    "65536789",
                    "Westlands, Nairobi",
                    "2312"
                ),
                AdminItems(
                    "Getty Ciru",
                    "65536789",
                    "Westlands, Nairobi",
                    "2312"
                ),
                AdminItems(
                    "Getty Ciru",
                    "65536789",
                    "Westlands, Nairobi",
                    "2312"
                ),
                AdminItems(
                    "Getty Ciru",
                    "65536789",
                    "Westlands, Nairobi",
                    "2312"
                )

            ))
    }
}

@Composable
fun Item(adminItems:List<AdminItems>) {
    LazyColumn(
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxHeight()
    ){
        items(adminItems.size){
            ItemCard(adminItems = adminItems[it])
        }
    }
}


@Composable
fun ItemCard(adminItems: AdminItems) {
    Card(
        onClick = {
//                  When clicked inaonyesha description of the order
        },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(16.dp)) {
           Text(text = adminItems.name, fontWeight = FontWeight.Bold)
           Text(text = adminItems.phoneNumber)
            Spacer(modifier = Modifier.padding(6.dp))
           Text(text = adminItems.location)
           Text(text = adminItems.time)
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewItemsScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        ItemsOrdered()
    }
}