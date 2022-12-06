@file:OptIn(ExperimentalPagerApi::class)

package com.ciru.frama.ui.theme.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.ui.theme.Orange
import com.ciru.frama.ui.theme.background
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@Composable
fun OrdersScreen() {
    val list = listOf(TabItem.CurrentOrders,TabItem.PastOrders,TabItem.CancelledOrders)
    val pagerState = rememberPagerState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Tabs(tabs = list, pagerState = pagerState)
            TabContent(tabs = list, pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    tabs:List<TabItem>,
    pagerState: PagerState
){
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        indicator = {tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(
                    pagerState = pagerState,
                    tabPositions = tabPositions,
                ),
                color = Color.Blue,
                height = TabRowDefaults.IndicatorHeight * 1F
            )
        }
    ) {
        tabs.forEachIndexed{index, tabItem ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                text = {
                    Text(
                        text = tabItem.title,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    ) }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(tabs: List<TabItem>, pagerState: PagerState){
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].pages()
    }
}




@Preview(showBackground = true, )
@Composable
fun OrdersScreenPreview(){
    OrdersScreen()
}