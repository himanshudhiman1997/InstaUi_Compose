package com.himanshu.instagram

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)
                .padding(top = 10.dp)
        ) {
//            TextField(
//                value = text,
//                onValueChange = { text = it },
//                modifier = Modifier
//                    .padding(horizontal = 10.dp)
//                    .fillMaxWidth()
//                    .height(40.dp)
//                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp)),
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    leadingIconColor = Color.LightGray,
//                    focusedBorderColor = Color.Transparent,
//                    cursorColor = Color.LightGray,
//                    unfocusedBorderColor = Color.Transparent
//                ),
//                textStyle = TextStyle(textAlign = TextAlign.Start),
//                leadingIcon = {
//                    SearchLeadingIcon()
//                },
//                placeholder = {
//                    Text(
//                        text = "Search",
//                        fontSize = 14.sp,
//                        color = Color.LightGray,
//                        textAlign = TextAlign.Start
//                    )
//                },
//            )
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
                    .height(40.dp)
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp)),
                decorationBox = {
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search icon",
                                modifier = Modifier
                                    .size(18.dp),
                            )
                            Text(text = "Search", modifier = Modifier.padding(start = 5.dp))
                        }
                    }
                }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(8f)
        ) {

            RandomPostsSection(
                photosList = listOf(
                    painterResource(id = R.drawable.post6),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.profile_image),
                    painterResource(id = R.drawable.post1),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.post1),
                    painterResource(id = R.drawable.post6),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.profile_image),
                    painterResource(id = R.drawable.post1),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.profile_image)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SearchLeadingIcon() {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "Search Icon",
        modifier = Modifier.size(15.dp)
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RandomPostsSection(photosList: List<Painter>, modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        verticalItemSpacing = 0.5.dp,
        horizontalArrangement = Arrangement.spacedBy(0.5.dp),
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(3),
        content = {
            items(photosList.size) {
                Image(
                    painter = photosList[it],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .border(
                            width = 0.1.dp, color = Color.White
                        )
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        })
}