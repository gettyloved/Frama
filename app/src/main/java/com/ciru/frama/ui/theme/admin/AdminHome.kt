@file:OptIn(ExperimentalPagerApi::class)

package com.ciru.frama.ui.theme.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.frama.ui.screens.admin.TabItem
import com.ciru.frama.ui.theme.FramaTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@Composable
fun AdminHome() {
    val tabList = listOf(TabItem.Ordered, TabItem.Deliverd)
    val pagerState = rememberPagerState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Tabs(tabs = tabList, pagerState = pagerState)
            TabContent(tabs = tabList, pagerState = pagerState)
        }
    }
}



@Composable
fun Tabs(
    tabs:List<TabItem>,
    pagerState: PagerState
){
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = {tabPositions ->
            Modifier.pagerTabIndicatorOffset(
                pagerState = pagerState,
                tabPositions = tabPositions
            ).fillMaxHeight()
        }
    ) {
        tabs.forEachIndexed{index, tabItem ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                text = {
                    Text(
                        text = tabItem.title,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                     }
            )
        }
    }
}


@Composable
fun TabContent(tabs: List<TabItem>, pagerState: PagerState){
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].pages()
    }
}

@Preview(showBackground = true)
@Composable
fun FPreview() {
    FramaTheme {
        AdminHome()
    }
}