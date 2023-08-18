package com.himanshu.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshu.instagram.ui.theme.InstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    var selectedTabIndex by remember {
                        mutableStateOf(0)
                    }

                    Column(modifier = Modifier.fillMaxSize()) {

                        when (selectedTabIndex) {
                            0 -> HomeScreen(modifier = Modifier.weight(9.3f))
                            1 -> SearchScreen(modifier = Modifier.weight(9.3f))
                            2 -> AddContentScreen(modifier = Modifier.weight(9.3f))
                            3 -> ReelsScreen(modifier = Modifier.weight(9.3f))
                            4 -> ProfileScreen(modifier = Modifier.weight(9.3f))
                        }

                        BaseView(
                            images = listOf(
                                Icons.Default.Home,
                                Icons.Default.Search,
                                Icons.Default.Add,
                                Icons.Default.PlayArrow,
                                Icons.Default.AccountCircle
                            ),
                            modifier = Modifier.weight(0.7f)
                        ) {
                            selectedTabIndex = it
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BaseView(
    modifier: Modifier = Modifier,
    images: List<ImageVector>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    var inactiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        images.forEachIndexed { index, imageWithText ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    imageVector = imageWithText,
                    contentDescription = null,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(24.dp)
                        .border(
                            1.dp,
                            if (index == 2) Color.Black else Color.Transparent,
                            CircleShape
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstagramTheme {
        //BaseView()
    }
}