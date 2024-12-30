package com.dinesh.jetpackcompose.painting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawScreen() {

    Column {

        TopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.primary),
            title = {
                Text(text = "Color Picker",
                    color = Color.White,
                    fontSize = 18.sp
                )
            },
            actions = {
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(3.dp)
                        .width(40.dp)
                ) {

                }
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(3.dp)
                        .width(40.dp)
                ) {

                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(3.dp)
                        .width(40.dp)
                ) {

                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(3.dp)
                        .width(40.dp)
                ) {

                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color.LightGray),
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(3.dp)

                ) {
                    Text(text = "Clear")
                }

            }
        )
    }
}