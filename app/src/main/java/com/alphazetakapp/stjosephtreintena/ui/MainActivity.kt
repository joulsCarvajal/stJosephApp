package com.alphazetakapp.stjosephtreintena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alphazetakapp.stjosephtreintena.Navigation.AppNavigation
import com.alphazetakapp.stjosephtreintena.ui.theme.StjosephtreintenaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Este sería el tema de arranque
        setTheme(R.style.Theme_App_Starting)

        setContent {
            StjosephtreintenaTheme {
                /*val screenSplash = installSplashScreen().setKeepOnScreenCondition{}*/
                AppNavigation()
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


