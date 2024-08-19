package com.dinesh.jetpackcompose.biometric_auth.philp_lackner

import android.content.Context
import android.content.Intent
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BiometricPage(modifier: Modifier = Modifier, context : Context) {

    val promptManager by lazy {
        BiometricPromptManager(context)
    }


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