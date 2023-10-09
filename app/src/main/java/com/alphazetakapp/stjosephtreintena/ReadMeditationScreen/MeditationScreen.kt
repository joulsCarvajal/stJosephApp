package com.alphazetakapp.stjosephtreintena

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alphazetakapp.stjosephtreintena.model.MeditationDay
import kotlin.math.max

@Composable
fun MeditationScreen(dayNum: Int, day: String, dailyRecord: Int, context: Context) {
    val backColor = colorResource(id = R.color.backgroundColorApp)
    val contrastColor = colorResource(id = R.color.contrastColorApp)
    val meditationTextResId =
        context.resources.getIdentifier("meditation_day_$dayNum", "string", context.packageName)
    val meditationText = context.getString(meditationTextResId)

    val meditationTextRosaryId =
        context.resources.getIdentifier(
            "meditation_screen_text_rosary",
            "string",
            context.packageName
        )
    val meditationTextRosary = context.getString(meditationTextRosaryId)

    val meditationTextLetaniesId =
        context.resources.getIdentifier(
            "meditation_screen_text_letanies",
            "string",
            context.packageName
        )
    val meditationTextLetanies = context.getString(meditationTextLetaniesId)

    val meditationTextFinalPrayId =
        context.resources.getIdentifier(
            "meditation_screen_text_final_pray",
            "string",
            context.packageName
        )
    val meditationTextFinalPray = context.getString(meditationTextFinalPrayId)


    val meditationDays = listOf(
        MeditationDay(1, meditationText),
        MeditationDay(2, meditationText),
        MeditationDay(3, meditationText),
        MeditationDay(4, meditationText),
        MeditationDay(5, meditationText),
        MeditationDay(6, meditationText),
        MeditationDay(7, meditationText),
        MeditationDay(8, meditationText),
        MeditationDay(9, meditationText),
        MeditationDay(10, meditationText),
        MeditationDay(11, meditationText),
        MeditationDay(12, meditationText),
        MeditationDay(13, meditationText),
        MeditationDay(14, meditationText),
        MeditationDay(15, meditationText),
        MeditationDay(16, meditationText),
        MeditationDay(17, meditationText),
        MeditationDay(18, meditationText),
        MeditationDay(19, meditationText),
        MeditationDay(20, meditationText),
        MeditationDay(21, meditationText),
        MeditationDay(22, meditationText),
        MeditationDay(23, meditationText),
        MeditationDay(24, meditationText),
        MeditationDay(25, meditationText),
        MeditationDay(26, meditationText),
        MeditationDay(27, meditationText),
        MeditationDay(28, meditationText),
        MeditationDay(29, meditationText),
        MeditationDay(30, meditationText)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backColor)
            .padding(12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(contrastColor)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                border = BorderStroke(0.4.dp, color = Color.LightGray),
                elevation = 5.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(contrastColor),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "TREINTENA A SAN JOSÉ \n $day",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        ExpandableTextRosary(
            rosary = meditationTextRosary
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(contrastColor)
                .padding(4.dp)
                .height(20.dp), contentAlignment = Alignment.TopStart
        ) {
            PlayAudioRosary(context = context)
        }
        Spacer(modifier = Modifier.padding(4.dp))
        ExpandableTextLitanies(
            litanies = meditationTextLetanies
        )

        Spacer(modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(contrastColor)
                .padding(4.dp)
                .height(20.dp), contentAlignment = Alignment.TopStart
        ) {
            PlayAudioLitanies(context = context)
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Meditation(meditationDays, dayNum)
        Spacer(modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(contrastColor)
                .padding(4.dp)
                .height(20.dp), contentAlignment = Alignment.TopStart
        ) {
            PlayAudioDailyMeditatiobn(context = context, dailyRecord)
        }
        Spacer(modifier = Modifier.padding(4.dp))
        FinalPray(
            finalPray = meditationTextFinalPray
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(contrastColor)
                .padding(4.dp)
                .height(20.dp), contentAlignment = Alignment.TopStart
        ) {
            PlayAudioFinalPray(context = context)
        }
    }
}

@Composable
fun PlayAudioRosary(context: Context) {
    var mp: MediaPlayer? by remember { mutableStateOf(null) }
//    val isPlaying: Boolean by meditationScreenViewModel.isPlaying.observeAsState(initial = false)
    var isPlaying by remember { mutableStateOf(false) }
    var playbackSpeed by remember { mutableStateOf(1.0f) }

    DisposableEffect(Unit) {
        mp = MediaPlayer.create(context, R.raw.rosariosanjose)

        onDispose {
            mp?.release()
            mp = null
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            IconButton(
                onClick = {
                    if (isPlaying) {
                        mp?.pause()
                        isPlaying = false
//                        meditationScreenViewModel.onMeditationChanged(isPlaying = false)
                    } else {
                        mp?.let {
                            it.playbackParams = it.playbackParams.setSpeed(playbackSpeed)
                        }
                        /*meditationScreenViewModel.onMeditationChanged(isPlaying = true)*/
                        isPlaying = true
                    }
                }, modifier = Modifier.size(35.dp)
            ) {
                if (isPlaying) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pause),
                        contentDescription = "",
                        tint = Color.White
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

            IconButton(
                onClick = {
                    mp?.stop()
                    mp?.prepare()
                    isPlaying = false
                    //meditationScreenViewModel.onMeditationChanged(isPlaying = false)
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_stop),
                    contentDescription = "",
                    tint = Color.White
                )
            }

            // Botones para ajustar la velocidad de reproducción
            IconButton(
                onClick = {
                    // Incrementar la velocidad de reproducción en 0.25x
                    playbackSpeed += 0.25f
                    mp?.playbackParams = mp?.playbackParams?.setSpeed(playbackSpeed)!!
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_up),
                    contentDescription = "Aumentar velocidad",
                    tint = Color.White
                )
            }

            IconButton(
                onClick = {
                    // Disminuir la velocidad de reproducción en 0.25x, asegurándose de que no sea menor que 0.25x
                    playbackSpeed = max(0.25f, playbackSpeed - 0.25f)
                    mp?.playbackParams = mp?.playbackParams?.setSpeed(playbackSpeed)!!
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_down),
                    contentDescription = "Reducir velocidad",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun PlayAudioLitanies(context: Context) {
    var mp: MediaPlayer? by remember { mutableStateOf(null) }
    /*val isPlaying: Boolean by meditationScreenViewModel.isPlaying.observeAsState(initial = false)*/
    var isPlaying by remember { mutableStateOf(false) }
    var playbackSpeed by remember { mutableStateOf(1.0f) } // Inicialmente, la velocidad de reproducción es 1.0x (normal)

    DisposableEffect(Unit) {
        mp = MediaPlayer.create(context, R.raw.letanias)

        onDispose {
            mp?.release()
            mp = null
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            IconButton(
                onClick = {
                    if (isPlaying) {
                        mp?.pause()
                        //meditationScreenViewModel.onMeditationChanged(isPlaying = false)
                        isPlaying = false
                    } else {
                        mp?.let {
                            it.playbackParams =
                                it.playbackParams.setSpeed(playbackSpeed) // Establecer la velocidad de reproducción
                            it.start()
                        }
                        //meditationScreenViewModel.onMeditationChanged(isPlaying = true)
                        isPlaying = true
                    }
                }, modifier = Modifier.size(35.dp)
            ) {
                if (isPlaying) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pause),
                        contentDescription = "",
                        tint = Color.White
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

            IconButton(
                onClick = {
                    mp?.stop()
                    mp?.prepare()
                    //meditationScreenViewModel.onMeditationChanged(isPlaying = false)
                    isPlaying = false
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_stop),
                    contentDescription = "",
                    tint = Color.White
                )
            }

            // Botones para ajustar la velocidad de reproducción
            IconButton(
                onClick = {
                    // Incrementar la velocidad de reproducción en 0.25x
                    playbackSpeed += 0.25f
                    mp?.playbackParams = mp?.playbackParams?.setSpeed(playbackSpeed)!!
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_up),
                    contentDescription = "Aumentar velocidad",
                    tint = Color.White
                )
            }

            IconButton(
                onClick = {
                    // Disminuir la velocidad de reproducción en 0.25x, asegurándose de que no sea menor que 0.25x
                    playbackSpeed = max(0.25f, playbackSpeed - 0.25f)
                    mp?.playbackParams = mp?.playbackParams?.setSpeed(playbackSpeed)!!
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_down),
                    contentDescription = "Reducir velocidad",
                    tint = Color.White
                )
            }
        }
    }
}


@Composable
fun PlayAudioDailyMeditatiobn(
    context: Context,
    dailyRecord: Int
) {
    var mp: MediaPlayer? by remember { mutableStateOf(null) }
    /*val isPlaying: Boolean by meditationScreenViewModel.isPlaying.observeAsState(initial = false)*/
    var isPlaying by remember { mutableStateOf(false) }
    var playbackSpeed by remember { mutableStateOf(1.0f) }

    DisposableEffect(Unit) {
        mp = MediaPlayer.create(context, dailyRecord)

        onDispose {
            mp?.release()
            mp = null
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            IconButton(
                onClick = {
                    if (isPlaying) {
                        mp?.pause()
                        /*meditationScreenViewModel.onMeditationChanged(isPlaying = false)*/
                        isPlaying = false
                    } else {
                        mp?.let {
                            it.playbackParams =
                                it.playbackParams.setSpeed(playbackSpeed) // Establecer la velocidad de reproducción
                            it.start()
                        }
                        /*meditationScreenViewModel.onMeditationChanged(isPlaying = true)*/
                        isPlaying = true
                    }
                }, modifier = Modifier.size(35.dp)
            ) {
                if (isPlaying) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pause),
                        contentDescription = "",
                        tint = Color.White
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

            IconButton(
                onClick = {
                    mp?.stop()
                    mp?.prepare()
                    //meditationScreenViewModel.onMeditationChanged(isPlaying = false)
                    isPlaying = false
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_stop),
                    contentDescription = "",
                    tint = Color.White
                )
            }

            // Botones para ajustar la velocidad de reproducción
            IconButton(
                onClick = {
                    // Incrementar la velocidad de reproducción en 0.25x
                    playbackSpeed += 0.25f
                    mp?.playbackParams = mp?.playbackParams?.setSpeed(playbackSpeed)!!
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_up),
                    contentDescription = "Aumentar velocidad",
                    tint = Color.White
                )
            }

            IconButton(
                onClick = {
                    // Disminuir la velocidad de reproducción en 0.25x, asegurándose de que no sea menor que 0.25x
                    playbackSpeed = max(0.25f, playbackSpeed - 0.25f)
                    mp?.playbackParams = mp?.playbackParams?.setSpeed(playbackSpeed)!!
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_down),
                    contentDescription = "Reducir velocidad",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun PlayAudioFinalPray(context: Context) {
    var mp: MediaPlayer? by remember { mutableStateOf(null) }
    /*val isPlaying: Boolean by meditationScreenViewModel.isPlaying.observeAsState(initial = false)*/
    var isPlaying by remember { mutableStateOf(false) }
    var playbackSpeed by remember { mutableStateOf(1.0f) }

    DisposableEffect(Unit) {
        mp = MediaPlayer.create(context, R.raw.oracionfinal)

        onDispose {
            mp?.release()
            mp = null
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            IconButton(
                onClick = {
                    if (isPlaying) {
                        mp?.pause()
                        /*meditationScreenViewModel.onMeditationChanged(false)*/
                        isPlaying = false
                    } else {
                        mp?.let {
                            it.playbackParams =
                                it.playbackParams.setSpeed(playbackSpeed) // Establecer la velocidad de reproducción
                            it.start()
                        }
//                        meditationScreenViewModel.onMeditationChanged(true)
                        isPlaying = true
                    }
                }, modifier = Modifier.size(35.dp)
            ) {
                if (isPlaying) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pause),
                        contentDescription = "",
                        tint = Color.White
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

            IconButton(
                onClick = {
                    mp?.stop()
                    mp?.prepare()
                    /*meditationScreenViewModel.onMeditationChanged(false)*/
                    isPlaying = false
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_stop),
                    contentDescription = "",
                    tint = Color.White
                )
            }

            // Botones para ajustar la velocidad de reproducción
            IconButton(
                onClick = {
                    // Incrementar la velocidad de reproducción en 0.25x
                    playbackSpeed += 0.25f
                    mp?.playbackParams = mp?.playbackParams?.setSpeed(playbackSpeed)!!
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_up),
                    contentDescription = "Aumentar velocidad",
                    tint = Color.White
                )
            }

            IconButton(
                onClick = {
                    // Disminuir la velocidad de reproducción en 0.25x, asegurándose de que no sea menor que 0.25x
                    playbackSpeed = max(0.25f, playbackSpeed - 0.25f)
                    mp?.playbackParams = mp?.playbackParams?.setSpeed(playbackSpeed)!!
                },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume_down),
                    contentDescription = "Reducir velocidad",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun ExpandableTextRosary(rosary: String) {
    var isExpanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(rosary) }

    val icon = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    val heightModifier =
        Modifier
            .clickable { isExpanded = !isExpanded }
            .animateContentSize()
            .then(
                if (isExpanded) Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp) // Añade padding horizontal para mantener el ancho en pantalla completa
                else Modifier
                    .height(50.dp)
            )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
            .then(heightModifier)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = if (isExpanded) text else text.take(18), // Mostrar solo una parte del texto cuando está contraído
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .padding(end = 8.dp)
                        .weight(1f)
                )
            }
        }
    }
}


@Composable
fun ExpandableTextLitanies(litanies: String) {
    var isExpanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(litanies) }

    val icon = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    val heightModifier =
        Modifier
            .clickable { isExpanded = !isExpanded }
            .animateContentSize()
            .then(
                if (isExpanded) Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp) // Añade padding horizontal para mantener el ancho en pantalla completa
                else Modifier
                    .height(50.dp)
            )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
            .then(heightModifier)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = if (isExpanded) text else text.take(19), // Mostrar solo una parte del texto cuando está contraído
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .padding(end = 8.dp)
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
fun Meditation(meditationDays: List<MeditationDay>, initialDayNumber: Int) {
    var isExpanded by remember { mutableStateOf(false) }
    var dayNumber by remember { mutableStateOf(initialDayNumber) }
    val meditationDay = meditationDays.find { it.dayNumber == dayNumber }
    var textNotFounded = meditationDay?.text ?: "Día no encontrado"

    val icon = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    val heightModifier =
        Modifier
            .clickable { isExpanded = !isExpanded }
            .animateContentSize()
            .then(
                if (isExpanded) Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp)
                else Modifier
                    .height(50.dp)
            )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
            .then(heightModifier)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "MEDITACIÓN DÍA $dayNumber: ${
                        if (isExpanded) textNotFounded else textNotFounded.take(
                            0
                        )
                    }",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 18.sp,
                    color = Color.Black,
                )
            }
        }
    }
}

@Composable
fun FinalPray(finalPray: String) {
    var isExpanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(finalPray) }

    val icon = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    val heightModifier =
        Modifier
            .clickable { isExpanded = !isExpanded }
            .animateContentSize()
            .then(
                if (isExpanded) Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp) // Añade padding horizontal para mantener el ancho en pantalla completa
                else Modifier
                    .height(50.dp)
            )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
            .then(heightModifier)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = if (isExpanded) text else text.take(19),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .padding(end = 8.dp)
                        .weight(1f)
                )
            }
        }
    }
}

