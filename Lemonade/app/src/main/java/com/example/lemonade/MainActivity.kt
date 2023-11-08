package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold (
        Modifier.background(Color.Red),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFF2EB63)
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    LemonadeTextAndImage(
                        imagePainter = painterResource(R.drawable.lemon_tree),
                        imageDescription = "Lemon tree",
                        text = "Tap the lemon tree to select a lemon",
                        onImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }

                2 -> {
                    LemonadeTextAndImage(
                        imagePainter = painterResource(R.drawable.lemon_squeeze),
                        imageDescription = "Lemon",
                        text = "Keep tapping the lemon to squeeze it",
                        onImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                    )
                }

                3 -> {
                    LemonadeTextAndImage(
                        imagePainter = painterResource(R.drawable.lemon_drink),
                        imageDescription = "Glass of lemonade",
                        text = "Tap the lemonade to drink it",
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }

                else -> {
                    LemonadeTextAndImage(
                        imagePainter = painterResource(R.drawable.lemon_restart),
                        imageDescription = "Empty glass",
                        text = "Tap the empty glass to start again",
                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }

//                1 -> {
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center,
//                        modifier = Modifier.fillMaxSize()
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.lemon_tree),
//                            contentDescription = "Lemon tree",
//                            modifier = Modifier
//                                .wrapContentSize()
//                                .clickable {
//                                    currentStep = 2
//                                }
//                        )
//                        Spacer(modifier = Modifier.height(32.dp))
//                        Text(
//                            text = "Tap the lemon tree to select a lemon",
//                            fontSize = 18.sp
//                        )
//                    }
//                }

            //        2 -> {
            //            Column(
            //                horizontalAlignment = Alignment.CenterHorizontally,
            //                verticalArrangement = Arrangement.Center,
            //                modifier = Modifier.fillMaxSize()
            //            ) {
            //                Image(
            //                    painter = painterResource(R.drawable.lemon_squeeze),
            //                    contentDescription = "Lemon",
            //                    modifier = Modifier
            //                        .wrapContentSize()
            //                        .clickable {
            //                            currentStep = 3
            //                            sqeezeCount = (0..4).random()
            //                        }
            //                )
            //                Spacer(modifier = Modifier.height(32.dp))
            //                Text(
            //                    text = "Keep tapping the lemon to squeeze it",
            //                    fontSize = 18.sp
            //                )
            //            }
            //        }
            //        3 -> {
            //            Column(
            //                horizontalAlignment = Alignment.CenterHorizontally,
            //                verticalArrangement = Arrangement.Center,
            //                modifier = Modifier.fillMaxSize()
            //            ) {
            //                Image(
            //                    painter = painterResource(R.drawable.lemon_drink),
            //                    contentDescription = "Glass of lemonade",
            //                    modifier = Modifier
            //                        .wrapContentSize()
            //                        .clickable {
            //                            currentStep = 4
            //                        }
            //                )
            //                Spacer(modifier = Modifier.height(32.dp))
            //                Text(
            //                    text = "Tap the lemonade to drink it",
            //                    fontSize = 18.sp
            //                )
            //            }
            //        }
            //        else -> {
            //            Column(
            //                horizontalAlignment = Alignment.CenterHorizontally,
            //                verticalArrangement = Arrangement.Center,
            //                modifier = Modifier.fillMaxSize()
            //            ) {
            //                Image(
            //                    painter = painterResource(R.drawable.lemon_restart),
            //                    contentDescription = "Empty glass",
            //                    modifier = Modifier
            //                        .wrapContentSize()
            //                        .clickable {
            //                            currentStep = 1
            //                        }
            //                )
            //                Spacer(modifier = Modifier.height(32.dp))
            //                Text(
            //                    text = "Tap the empty glass to start again",
            //                    fontSize = 18.sp
            //                )
            //            }
            //        }
        }
    }
}

@Composable
private fun LemonadeTextAndImage(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
    imageDescription: String,
    text: String,
    onImageClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA1E69A))
        ) {
            Image(
                painter = imagePainter,
                contentDescription = imageDescription,
                modifier = modifier
                    .wrapContentSize()
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = text,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}