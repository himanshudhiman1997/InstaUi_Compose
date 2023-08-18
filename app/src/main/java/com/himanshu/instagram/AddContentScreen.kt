package com.himanshu.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AddContentScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta_logo),
        contentDescription = "Insta Logo",
        modifier = modifier.fillMaxSize()
    )
}