package com.alphazetakapp.stjosephtreintena

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen
import androidx.navigation.NavController
import com.alphazetakapp.stjosephtreintena.Navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()
        navController.navigate(Routes.MainScreen.routes)
    }
    Splash()
}

@Composable
fun Splash() {
    val backColor = colorResource(id = R.color.backgroundColorApp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "TREINTENA A SAN JOSE",
            modifier = Modifier.align(CenterHorizontally),
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.sanjoselogo),
            contentDescription = "Test Logo",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LinearProgressIndicator(
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}