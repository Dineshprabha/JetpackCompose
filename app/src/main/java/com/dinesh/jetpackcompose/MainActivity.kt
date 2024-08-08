package com.dinesh.jetpackcompose

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.dinesh.jetpackcompose.media_player.data.model.Msg
import com.dinesh.jetpackcompose.media_player.presentation.MediaViewModel
import com.dinesh.jetpackcompose.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
//            val toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
//            val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
            JetpackComposeTheme {
                MyApp()

            }
        }

    }
}

@Composable
fun MyApp() {
    val viewModel: MediaViewModel = hiltViewModel()
    val videos by viewModel.videos.collectAsState()

    LazyColumn {
        items(videos) { video ->
            VideoItem(video)
        }
    }
}

@Composable
fun VideoItem(msg: Msg) {
    val videoUrl: String = msg.video

    Log.i("Media: ", msg.toString())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val context = LocalContext.current
        val exoPlayer = remember {
            ExoPlayer.Builder(context).build().apply {
                setMediaItem(MediaItem.fromUri(videoUrl))
                prepare()
                playWhenReady = true
            }
        }

        AndroidView(
            factory = {
                PlayerView(context).apply {
                    player = exoPlayer
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(9 / 16f)
        )
        Text(text = msg.city, style = MaterialTheme.typography.titleMedium)
        Text(text = msg.user_info.username, style = MaterialTheme.typography.labelMedium)

    }
}

