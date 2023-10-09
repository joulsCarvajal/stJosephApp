package com.alphazetakapp.stjosephtreintena

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alphazetakapp.stjosephtreintena.Navigation.Routes

@Composable
fun PrepMeditation(navController: NavController) {
    val backColor = colorResource(id = R.color.backgroundColorApp)
    val contrastColor = colorResource(id = R.color.contrastColorApp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backColor)
            .padding(18.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(backColor)
                .padding(4.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "❤️ TREINTENA A  SAN JOSÉ ❤️\n" + "\uD83D\uDC63PASOS A SEGUIR\uD83D\uDC63\n" + "\n" + "1.- Rosario a San José\n" + "(te invitamos a escuchar el audio para ayudarte a entender  como se reza)\n" + "2- Letanías a San José\n" + "3.- Meditación\n" + "4.- Oración final.\n" + "\n" + "NOTA: Cada paso, va llevar su parte escrita y su audio\n" + "Por si quieres escucharla o leerla o ambas.",
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row(modifier = Modifier.align(Alignment.End)) {
            Button(
                onClick = { navController.navigate(Routes.DaysScreen.routes)},
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