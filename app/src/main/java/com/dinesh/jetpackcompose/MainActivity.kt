package com.dinesh.jetpackcompose

import android.content.Intent
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.dinesh.jetpackcompose.biometric_auth.philp_lackner.BiometricPromptManager
import com.dinesh.jetpackcompose.biometric_auth.philp_lackner.BiometricResult
import com.dinesh.jetpackcompose.media_player.data.model.Msg
import com.dinesh.jetpackcompose.media_player.presentation.MediaViewModel
import com.dinesh.jetpackcompose.ui.theme.JetpackComposeTheme


class MainActivity : AppCompatActivity() {

    private val promptManager by lazy {
        BiometricPromptManager(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
//            val toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
//            val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]

            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val biometricResult by promptManager.promptResult.collectAsState(initial = null)

                    val enrollmentLauncher =
                        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult(),
                            onResult = {
                                println("Activity result: $it")
                            })

                    LaunchedEffect(biometricResult) {
                        if (biometricResult is BiometricResult.AuthenticationNotSet) {
                            if (Build.VERSION.SDK_INT >= 30) {
                                val enrollment = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                                    putExtra(
                                        Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                                        BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                                    )
                                }
                                enrollmentLauncher.launch(enrollment)
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            promptManager.showBiometricPrompt(
                                title = "Biometric Prompt",
                                description = "Sample prompt description"
                            )
                        }) {
                            Text(text = "Authenticate")
                        }

                        biometricResult?.let { result ->
                            Text(
                                text = when (result) {
                                    is BiometricResult.AuthenticationError -> {
                                        "Authentication Error: ${result.error}"
                                    }

                                    BiometricResult.AuthenticationFailed -> {
                                        "Authentication Failed"
                                    }

                                    BiometricResult.AuthenticationNotSet -> {
                                        "Authentication Not set"
                                    }

                                    BiometricResult.AuthenticationSuccess -> {
                                        "Authentication Success"
                                    }

                                    BiometricResult.FeatureUnavailable -> {
                                        "Feature Unavailable"
                                    }

                                    BiometricResult.HardwareUnavailable -> {
                                        "Hardware Unavailable"
                                    }
                                }
                            )
                        }

                    }

                }

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

