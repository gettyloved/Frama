@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)

package com.ciru.frama.ui.theme.home

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciru.frama.R
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
                    Text(text = "Frama", color = Color.White)
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
            FrontPage()
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
fun FrontPage() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){}
}


@Preview(showSystemUi=true, showBackground = true, )
@Composable
fun HomePagePreview(){
    HomePage()
}
