package com.alphazetakapp.stjosephtreintena

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.alphazetakapp.stjosephtreintena.Navigation.Routes

@Composable
fun MainScreen(navController: NavController, context: Context) {
    val backColor = colorResource(id = R.color.backgroundColorApp)
    val meditationTextResId =
        context.resources.getIdentifier("main_screen_text", "string", context.packageName)
    val meditationText = context.getString(meditationTextResId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¿QUE ES LA TREINTENA A SAN JOSÉ?",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = meditationText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Row(modifier = Modifier.align(Alignment.End)) {
            Button(
                onClick = { navController.navigate(Routes.PrepMeditation.routes)},
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFF2A71B),
                    contentColor = Color.Black
                )
            ) {
                Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = "Next")
            }
        }
    }
}