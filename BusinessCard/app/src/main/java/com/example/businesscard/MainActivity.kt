package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF363140)), // 0xFFEADDFF 454554
        verticalArrangement = Arrangement.Bottom, ///////////////////
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(R.drawable.obi_wan_kenobi)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.business_card_name),
            fontSize = 30.sp,
            color = Color(0xFFB9AEEB),
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Text(
            text = stringResource(R.string.business_card_position),
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB9AEEB)
        )
        Spacer(modifier = Modifier.padding(bottom = 110.dp))
        ContactRow(
            icon = Icons.Rounded.Call,
            text = stringResource(R.string.business_card_phone_number)
        )
        ContactRow(
            icon = Icons.Rounded.Share,
            text = stringResource(R.string.business_card_telegram)
        )
        ContactRow(
            icon = Icons.Rounded.Email,
            text = stringResource(R.string.business_card_email)
        )
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }
}

@Composable
private fun ContactRow(
    text: String,
    icon: ImageVector
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFFB9AEEB),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text,
            color = Color(0xFFB9AEEB),
            modifier = Modifier.weight(3f))
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}