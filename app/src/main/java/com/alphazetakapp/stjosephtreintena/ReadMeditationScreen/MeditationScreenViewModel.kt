package com.alphazetakapp.stjosephtreintena.ReadMeditationScreen

import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeditationScreenViewModel: ViewModel() {

    private val _isPlaying = MutableLiveData<Boolean>()
    val isPlaying: LiveData<Boolean> = _isPlaying

    private val _playbackSpeed = MutableLiveData<Float>()
    val playbackSpeed: LiveData<Float> = _playbackSpeed

    private var mediaPlayer: MediaPlayer? = null

    /*init{
        _isPlaying.value = false
        _playbackSpeed.value = 1.0f
    }*/

    fun onMeditationChanged(isPlaying: Boolean){
        _isPlaying.value = isPlaying
    }

    /*fun onPlayBackSpeed(playbackSpeedChange: Float){
        val currentSpeed = _playbackSpeed.value ?: 1.0f // Valor predeterminado si _playbackSpeed es nulo
        val newPlaybackSpeed = max(0.25f, currentSpeed + playbackSpeedChange)
        _playbackSpeed.value = newPlaybackSpeed
        mediaPlayer?.let {
            it.playbackParams = it.playbackParams.setSpeed(newPlaybackSpeed)
        }
    }

    fun initializeMediaPlayer(context: Context, audioResource: Int){
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, audioResource)
    }

    fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun playAudio() {
        mediaPlayer?.start()
        _isPlaying.value = true
    }

    fun pauseAudio() {
        mediaPlayer?.pause()
        _isPlaying.value = false
        onMeditationChanged(isPlaying = false)
    }

    fun stopAudio() {
        mediaPlayer?.stop()
        mediaPlayer?.prepare()
        _isPlaying.value = false
    }*/
}