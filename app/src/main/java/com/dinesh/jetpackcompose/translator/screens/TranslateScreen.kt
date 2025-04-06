package com.dinesh.jetpackcompose.translator.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TranslatorScreen() {
    val context = LocalContext.current

    var inputText by remember { mutableStateOf("") }
    var translatedText by remember { mutableStateOf("") }
    var isTranslating by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val languageMap = TranslateLanguage.getAllLanguages().associateWith { Locale(it).displayLanguage }
    val languageList = languageMap.values.sorted()

    LaunchedEffect(Unit) {
        Log.i("LanguageList", Gson().toJson(languageMap))
        Log.i("LanguageList", Gson().toJson(languageList))
        Log.i("LanguageList", "LaunchedEffect triggered")
    }

    var selectedSource by remember { mutableStateOf("ENGLISH") }
    var selectedTarget by remember { mutableStateOf("KANNADA") }

    var expandedSource by remember { mutableStateOf(false) }
    var expandedTarget by remember { mutableStateOf(false) }

    val sourceLangCode = languageMap.entries.firstOrNull { it.value == selectedSource }?.key ?: TranslateLanguage.ENGLISH
    val targetLangCode = languageMap.entries.firstOrNull { it.value == selectedTarget }?.key ?: TranslateLanguage.KANNADA


    // Dynamic translator setup
    val translator by remember(selectedSource, selectedTarget) {
        mutableStateOf(
            Translation.getClient(
                TranslatorOptions.Builder()
                    .setSourceLanguage(sourceLangCode)
                    .setTargetLanguage(targetLangCode)
                    .build()
            )
        )
    }

    // Download language model on change
    LaunchedEffect(translator) {
        val conditions = DownloadConditions.Builder().build()
        translator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                errorMessage = null
            }
            .addOnFailureListener {
                errorMessage = "Model download failed: ${it.localizedMessage}"
            }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$selectedSource ➡ $selectedTarget Translator", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3F51B5)
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Language Selection Dropdowns
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box {
                        OutlinedButton(onClick = { expandedSource = true }) {
                            Text("From: $selectedSource")
                        }
                        DropdownMenu(expanded = expandedSource, onDismissRequest = { expandedSource = false }) {
                            languageList.forEach { lang ->
                                DropdownMenuItem(
                                    text = { Text(lang) },
                                    onClick = {
                                        selectedSource = lang
                                        expandedSource = false
                                    }
                                )
                            }
                        }
                    }

                    Box {
                        OutlinedButton(onClick = { expandedTarget = true }) {
                            Text("To: $selectedTarget")
                        }
                        DropdownMenu(expanded = expandedTarget, onDismissRequest = { expandedTarget = false }) {
                            languageList.forEach { lang ->
                                DropdownMenuItem(
                                    text = { Text(lang) },
                                    onClick = {
                                        selectedTarget = lang
                                        expandedTarget = false
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    label = { Text("Enter text in $selectedSource") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF3F51B5),
                        focusedLabelColor = Color(0xFF3F51B5)
                    )
                )

                Button(
                    onClick = {
                        isTranslating = true
                        errorMessage = null
                        translator.translate(inputText)
                            .addOnSuccessListener { result ->
                                translatedText = result
                                isTranslating = false
                            }
                            .addOnFailureListener {
                                errorMessage = it.localizedMessage
                                isTranslating = false
                            }
                    },
                    enabled = inputText.isNotBlank(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
                ) {
                    Text("Translate", color = Color.White)
                }

                Spacer(modifier = Modifier.height(24.dp))

                if (isTranslating) {
                    CircularProgressIndicator()
                } else if (errorMessage != null) {
                    Text(text = "Error: $errorMessage", color = Color.Red)
                } else if (translatedText.isNotBlank()) {
                    Text(
                        text = "Translated Text:",
                        style = TextStyle(fontSize = 16.sp),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = translatedText,
                        style = TextStyle(fontSize = 20.sp, color = Color(0xFF4CAF50)),
                        modifier = Modifier
                            .background(Color(0xFFE8F5E9))
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    )
}
