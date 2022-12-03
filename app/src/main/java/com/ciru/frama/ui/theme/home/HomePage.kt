@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class, ExperimentalMaterialApi::class
)

package com.ciru.frama.ui.theme.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciru.frama.R
import com.ciru.frama.ui.theme.BlueWhiteDark
import kotlinx.coroutines.launch

@Composable
fun HomePage() {
    val scope = rememberCoroutineScope()
    var backDropState = rememberBackdropScaffoldState(BackdropValue.Concealed)
    BackdropScaffold(
        scaffoldState = backDropState,
        appBar = {
            TopAppBar(
                title = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                        contentDescription = "menu",
                        Modifier
                            .size(20.dp)
                            .clickable {
                                scope.launch {
                                    if (backDropState.isConcealed)
                                        backDropState.reveal()
                                    else
                                        backDropState.conceal()
                                }
                            },
                        tint = Color.White
                    )
                    Text(text = "Frama", color = Color.White, modifier = Modifier.padding(5.dp))
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Search ,
                        contentDescription = "search",
                        Modifier.size(20.dp),
                        tint = Color.White
                    )
                }
            ) 
        },
        frontLayerContent = {
            FrontPage(homeItems = listOf(
                HomeItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "$28",
                    170.dp
                ),
                HomeItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "$28",
                    190.dp
                ),
                HomeItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "$28",
                    200.dp
                ),
                HomeItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "$28",
                    250.dp
                ),
                HomeItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "$28",
                    230.dp
                ),
                HomeItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "$28",
                    240.dp
                ),
                HomeItems(
                    R.drawable.tshirt,
                    "Wash & Fold",
                    "$28",
                    270.dp
                ),
            ))
        },
        backLayerContent = {
            BackdropMenuItems()
        }
    )
}

@Composable
private fun BackdropMenuItems() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuItem()
    }
}


@Composable
fun MenuItem() {
// settings, notification, customer Support
}


@Composable
fun FrontPage(homeItems: List<HomeItems>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(homeItems.size){
            FrontPageCard(homeItems = homeItems[it])
        }
    }
}

@Composable
fun FrontPageCard(homeItems: HomeItems) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .wrapContentSize()
            .height(homeItems.size)
            .clickable {  }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = homeItems.image),
                contentDescription ="service",
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = homeItems.title,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = homeItems.subTitle,
                color = BlueWhiteDark
            )
        }

    }
}


@Preview(showSystemUi=true, showBackground = true, )
@Composable
fun HomePagePreview(){
    HomePage()
}
