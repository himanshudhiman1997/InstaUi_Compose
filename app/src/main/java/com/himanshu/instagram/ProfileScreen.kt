package com.himanshu.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            TopBar(userName = "himanshu_dhiman_", modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(5.dp))
            ProfileSection()
            Spacer(modifier = Modifier.width(5.dp))
            ProfileDescription(
                name = "Himanshu Dhiman", description = "Coding to Code \uD83D\uDCBB"
            )
            Spacer(modifier = Modifier.height(7.dp))
            StoryHighLights(
                highLights = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.post1), text = "Manali"
                    ), ImageWithText(
                        image = painterResource(id = R.drawable.post2), text = "Leh"
                    ), ImageWithText(
                        image = painterResource(id = R.drawable.post3), text = "Devprayag"
                    ), ImageWithText(
                        image = painterResource(id = R.drawable.post4), text = "Jaisalmer"
                    ), ImageWithText(
                        image = painterResource(id = R.drawable.post5), text = "Coorg"
                    )
                ),
                modifier = Modifier.fillMaxWidth(),
                storyImageSize = 70.dp
            )
            Spacer(modifier = Modifier.height(10.dp))
            FollowingDetails(followedBy = listOf("divyam008", "nitishdmn"), othersCount = 17)
            Spacer(modifier = Modifier.height(10.dp))
            ButtonSection(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
        }

        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                )
            )
        ) {
            selectedTabIndex = it
        }

        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.post6),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.post1),
                    painterResource(id = R.drawable.profile_image),
                    painterResource(id = R.drawable.post2)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TopBar(userName: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(vertical = 13.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back button",
            tint = Color.Black
        )
        Text(
            text = userName,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notifications",
            tint = Color.Black
        )
        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
    }
}

@Composable
fun ProfileSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleImage(
            image = painterResource(id = R.drawable.profile_image),
            modifier = Modifier
                .size(100.dp)
                .weight(3f),
            borderColor = Color.LightGray
        )
        Spacer(modifier = Modifier.width(10.dp))
        ProfileNumbers(modifier = Modifier.weight(7f))
    }
}

@Composable
fun CircleImage(image: Painter, modifier: Modifier = Modifier, borderColor: Color) {
    Image(
        painter = image, contentDescription = "image", modifier = modifier
            .padding(3.dp)
            .clip(
                CircleShape
            )
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 2.dp, color = borderColor, shape = CircleShape)
            .border(width = 4.dp, color = Color.White, shape = CircleShape)
    )
}

@Composable
fun ColouredCircleImage(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image, contentDescription = "image", modifier = modifier
            .padding(3.dp)
            .clip(
                CircleShape
            )
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(listOf(Color.Magenta, Color.Yellow)),
                shape = CircleShape
            )
            .border(width = 4.dp, color = Color.White, shape = CircleShape)
    )
}

@Composable
fun ProfileNumbers(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
    ) {
        ProfileStatComponent(number = "89", title = "Posts")
        ProfileStatComponent(number = "348", title = "Followers")
        ProfileStatComponent(number = "408", title = "Following")
    }
}

@Composable
fun ProfileStatComponent(number: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = number, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title, fontSize = 16.sp)
    }
}

@Composable
fun ProfileDescription(
    name: String,
    description: String,
) {

    val lineHeight = 20.sp
    val letterSpacing = 0.5.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        if (description.isNotEmpty()) {
            Text(
                text = description, lineHeight = lineHeight, letterSpacing = letterSpacing
            )
        }
    }
}

@Composable
fun StoryHighLights(
    modifier: Modifier = Modifier,
    highLights: List<ImageWithText>,
    storyImageSize: Dp
) {
    LazyRow(modifier = modifier) {
        items(highLights.size) {
            Column(
                modifier = Modifier.padding(end = 3.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ColouredCircleImage(
                    image = highLights[it].image,
                    modifier = Modifier.size(storyImageSize)
                )
                if (highLights[it].text.isNotEmpty()) {
                    Text(
                        text = highLights[it].text,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun FollowingDetails(followedBy: List<String>, othersCount: Int) {
    if (followedBy.isNotEmpty()) {

        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black, fontWeight = FontWeight.SemiBold
                )
                append("Followed by ")
                followedBy.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()

                    if (index < followedBy.size - 1) {
                        append(", ")
                    }
                }

                if (othersCount > 2) {
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$othersCount others")
                }

            },
            letterSpacing = 0.5.sp,
            lineHeight = 20.sp
        )

    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 95.dp
    val height = 30.dp

    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .padding(end = 7.dp)
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .padding(end = 7.dp)
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .padding(end = 7.dp)
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .border(
                width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = "Action Button Icon", tint = Color.Black)
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, imageWithText ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = imageWithText.image,
                    contentDescription = imageWithText.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostSection(posts: List<Painter>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = modifier.scale(1.01f)) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 0.5.dp, color = Color.White
                    )
            )
        }
    }
}
