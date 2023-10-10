package com.alphazetakapp.stjosephtreintena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.alphazetakapp.stjosephtreintena.Navigation.AppNavigation
import com.alphazetakapp.stjosephtreintena.ui.theme.StjosephtreintenaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Este sería el tema de arranque
        setTheme(R.style.Theme_App_Starting)

        setContent {
            StjosephtreintenaTheme {
                val screenSplash = installSplashScreen()
                AppNavigation(screenSplash)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StjosephtreintenaTheme {

    }
}


