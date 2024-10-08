package com.example.datingapplication.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.example.datingapplication.R
import com.example.datingapplication.model.ProfilePictureState
import com.example.datingapplication.ui.components.ChatFooter
import com.example.datingapplication.ui.theme.Green1

@Composable
fun NewMatchView(
    pictureStates: List<ProfilePictureState>,
    onCloseClicked: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box {
        var currentIndex by remember { mutableIntStateOf(0) }
        var isTextVisible by remember { mutableStateOf(false) }
        var isFirstTime by remember { mutableStateOf(true) }

        //Picture
        when(val pictureState = pictureStates[currentIndex]) {
            is ProfilePictureState.Loading -> CircularProgressIndicator()
            is ProfilePictureState.Remote -> {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = pictureState.uri,
                    contentScale = ContentScale.Crop,
                    onState = {
                        if (it is AsyncImagePainter.State.Success && isFirstTime) {
                            isTextVisible = true
                            isFirstTime = false
                        }
                    },
                    contentDescription = null
                )
            }
        }

        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            enter = scaleIn(tween(300, easing = LinearEasing), initialScale = 5f),
            exit = fadeOut(),
            visible = isTextVisible
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.its_a).uppercase(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Green1,
                        fontStyle = FontStyle.Italic,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Black,

                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
                val density = LocalDensity.current
                Text(
                    modifier = Modifier.padding(0.dp),
                    text = stringResource(id = R.string.match).uppercase(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Green1,
                        fontStyle = FontStyle.Italic,
                        fontSize = 80.sp,
                        fontWeight = FontWeight.Black,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        shadow = Shadow(
                            color = Color.Blue.copy(alpha = .5f),
                            offset = with(density) {
                                Offset(4.dp.toPx(), 10.dp.toPx())
                            },
                            blurRadius = 3f
                        )
                    ),
                )

            }
        }
        Box(Modifier.fillMaxSize()) {
            //Upper picture index indicator
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                repeat(pictureStates.size) { index ->
                    Box(
                        Modifier
                            .weight(1f)
                            .height(3.dp)
                            .padding(horizontal = 4.dp)
                            .alpha(if (index == currentIndex) 1f else .5f)
                            .background(if (index == currentIndex) Color.White else Color.LightGray)
                    )
                }
            }
            //Clickable
            Row(Modifier.fillMaxSize()) {
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        if (currentIndex > 0) currentIndex--
                        isTextVisible = false
                    })
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        if (currentIndex < pictureStates.size - 1) currentIndex++
                        isTextVisible = false
                    }
                )
            }

            IconButton(
                onClick = onCloseClicked, modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    modifier = Modifier.size(40.dp),
                    tint = Color.White,
                    contentDescription = null
                )
            }
        }
    }
}
