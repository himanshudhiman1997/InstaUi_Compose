package com.himanshu.instagram

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReelsScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(0.85f)
                    .padding(start = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ColouredCircleImage(
                        image = painterResource(id = R.drawable.post4),
                        modifier = Modifier.size(35.dp)
                    )
                    Spacer(modifier = Modifier.size(width = 7.dp, height = 0.dp))
                    Text(text = "himanshu_dhiman_", fontSize = 14.sp)
                    Spacer(modifier = Modifier.size(width = 7.dp, height = 0.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(2.dp)
                            )
                            .padding(2.dp)
                            .width(10.dp)
                    ) {
                        Text(text = "Follow", fontWeight = FontWeight.SemiBold, fontSize = 12.sp)

                    }
                }
                Text(
                    text = "Instagram UI made using Compose UI - Part of Jetpack Library",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(3.dp)
                        .basicMarquee(2),
                    maxLines = 1
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CircleImage(
                        image = painterResource(id = R.drawable.post6),
                        borderColor = Color.Transparent,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.size(width = 7.dp, height = 0.dp))
                    Text(
                        text = "Liked by divyam_dhiman and 12,654 others",
                        fontSize = 13.sp,
                        modifier = Modifier.padding(3.dp),
                        maxLines = 1
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        modifier = Modifier.size(20.dp),
                        contentDescription = "Music icon"
                    )
                    Spacer(modifier = Modifier.size(width = 7.dp, height = 0.dp))
                    Text(
                        text = "hungry_chilli - Original Audio",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(3.dp),
                        maxLines = 1
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(0.15f)
            ) {
                userActionsNumbers(imageVector = Icons.Default.FavoriteBorder, text = "21.65k")
                Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
                userActionsNumbers(imageVector = Icons.Default.DateRange, text = "2023")
                Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
                userActionsNumbers(imageVector = Icons.Default.Send, text = "611")
                Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
                userActionsNumbers(imageVector = Icons.Default.Menu, text = "")
                Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
            }
        }
    }
}

@Composable
fun userActionsNumbers(imageVector: ImageVector, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = imageVector, contentDescription = "User action icon")

        if (text.isNotEmpty()) {
            Text(text = text, fontSize = 12.sp)
        }

    }
}