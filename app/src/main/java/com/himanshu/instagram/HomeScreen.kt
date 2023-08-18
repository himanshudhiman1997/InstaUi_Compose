package com.himanshu.instagram

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        TopBar(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        StorySection(modifier = Modifier.fillMaxWidth())
        PostsArea()
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {

    val pacificRegularFont = FontFamily(
        Font(R.font.pacifico_regular, FontWeight.SemiBold)
    )
    Row(modifier = modifier.padding(horizontal = 25.dp, vertical = 20.dp)) {
        Text(
            text = "Instagram",
            color = Color.Black,
            fontSize = 22.sp
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Down Arrow",
            tint = Color.Black,
            modifier = Modifier
                .padding(start = 3.dp)
                .align(Alignment.CenterVertically)
        )
        Row(
            horizontalArrangement = Arrangement.End, modifier = Modifier
                .padding(end = 10.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Heart",
                tint = Color.Black,
                modifier = Modifier.size(27.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_chat),
                contentDescription = "Messages",
                tint = Color.Black,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .size(27.dp)
            )
        }
    }
}

@Composable
fun StorySection(modifier: Modifier = Modifier) {
    StoryHighLights(
        highLights = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.post1), text = ""
            ), ImageWithText(
                image = painterResource(id = R.drawable.post2), text = ""
            ), ImageWithText(
                image = painterResource(id = R.drawable.post3), text = ""
            ), ImageWithText(
                image = painterResource(id = R.drawable.post4), text = ""
            ), ImageWithText(
                image = painterResource(id = R.drawable.post5), text = ""
            )
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp),
        storyImageSize = 85.dp
    )
}

@Composable
fun PostsArea() {
    PhotoPost(
        R.drawable.post5,
        99,
        " Above All \uD83C\uDF0F",
        "divyam008, nitishdmn",
        commentsNumber = 8
    )
    PhotoPost(R.drawable.post6, 103, "♠️", "shivamdmn", commentsNumber = 3)
    PhotoPost(
        R.drawable.post1,
        78,
        "Underground  \uD83E\uDE7B \uD83E\uDE7C",
        "divyam008",
        commentsNumber = 11
    )
    PhotoPost(
        R.drawable.post3,
        111,
        "\uD83D\uDC41",
        "shivamofficial, nitishdmn",
        commentsNumber = 2
    )
}

@Composable
fun PhotoPost(
    @DrawableRes image: Int,
    othersLikeNumber: Int,
    caption: String,
    likesByName: String,
    commentsNumber: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ColouredCircleImage(
                image = painterResource(id = R.drawable.profile_image),
                modifier = Modifier
                    .size(42.dp)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(8f)
            ) {
                Text(text = "himanshu_dhiman_", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(
                    text = "Kurukshetra",
                    fontSize = 12.sp
                )
            }
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Extra options for post",
                modifier = Modifier
                    .size(20.dp)
                    .weight(1f)
            )
        }
        Image(
            painter = painterResource(id = image),
            contentDescription = "post picture",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = false),
            contentScale = ContentScale.FillWidth
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            Row(modifier = Modifier.weight(9f), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Post Like",
                    modifier = Modifier
                        .padding(end = 18.dp)
                        .size(27.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = "Post Comment",
                    modifier = Modifier
                        .padding(end = 18.dp)
                        .size(23.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = "Post Share",
                    modifier = Modifier.size(28.dp)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_save),
                contentDescription = "Post Save",
                modifier = Modifier
                    .size(25.dp)
                    .weight(1f)
            )

        }
        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(color = Color.Black, fontWeight = FontWeight.SemiBold)
                append("Liked by ")
                pushStyle(boldStyle)
                append(likesByName)
                pop()
                append(" and ")
                pushStyle(boldStyle)
                append("$othersLikeNumber others")
                pop()
            },
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 3.dp)
        )
        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(color = Color.Black, fontWeight = FontWeight.SemiBold)
                pushStyle(boldStyle)
                append("himanshu_dhiman_")
                pop()
                append(caption)
            },
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 1.dp)
        )
        Text(
            text = "View all $commentsNumber comments",
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 1.dp),
            color = Color(0xFF818585)
        )
        Text(
            text = "3 hours ago",
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 1.dp),
            color = Color(0xFF818585)
        )
    }
}

