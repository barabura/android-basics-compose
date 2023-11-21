package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
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
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceApp() {
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Art Space",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFB7ADC4)
                )
            )
        }

    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    ArtSpaceLayout(
                        imagePainter = painterResource(id = R.drawable.stephan_valentin),
                        imageDescription = "Stephan Valentin Art",
                        artName = "Vintage car driver",
                        artAuthor = "Stephan Valentin (2018)",
                        onPreviousClick = {currentStep = 6},
                        onNextClick = {currentStep = 2}
                    )
                }
                2 -> {
                    ArtSpaceLayout(
                        imagePainter = painterResource(id = R.drawable.esteban_chinchilla),
                        imageDescription = "Esteban Chinchilla Art",
                        artName = "New York Subway",
                        artAuthor = "Esteban Chinchilla (2020)",
                        onPreviousClick = {currentStep = 1},
                        onNextClick = {currentStep = 3}
                    )
                }
                3 -> {
                    ArtSpaceLayout(
                        imagePainter = painterResource(id = R.drawable.lin_zhaohai),
                        imageDescription = "Lin Zhaohai Art",
                        artName = "Big City View",
                        artAuthor = "Lin Zhaohai (2023)",
                        onPreviousClick = {currentStep = 2},
                        onNextClick = {currentStep = 4}
                    )
                }
                4 -> {
                    ArtSpaceLayout(
                        imagePainter = painterResource(id = R.drawable.fred_nassar),
                        imageDescription = "Fred Nassar Art",
                        artName = "Akihabara street, Tokyo",
                        artAuthor = "Fred Nassar (2019)",
                        onPreviousClick = {currentStep = 3},
                        onNextClick = {currentStep = 5}
                    )
                }
                5 -> {
                    ArtSpaceLayout(
                        imagePainter = painterResource(id = R.drawable.mak),
                        imageDescription = "Mak Art",
                        artName = "The cross",
                        artAuthor = "Mak (2023)",
                        onPreviousClick = {currentStep = 4},
                        onNextClick = {currentStep = 6}
                    )
                }
                else -> {
                    ArtSpaceLayout(
                        imagePainter = painterResource(id = R.drawable.sarah_embee),
                        imageDescription = "Sarah Embee Art",
                        artName = "Sunny York day, UK",
                        artAuthor = "Sarah Embee (2020)",
                        onPreviousClick = {currentStep = 5},
                        onNextClick = {currentStep = 1}
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
    imageDescription: String,
    artName: String,
    artAuthor: String,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imagePainter,
            contentDescription = imageDescription
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            Text(text = artName)
            Text(text = artAuthor)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onPreviousClick,
                modifier = modifier
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = onNextClick,
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            ) {
                Text(text = "Next")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}