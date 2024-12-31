package com.dinesh.jetpackcompose.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinesh.jetpackcompose.gemini_chat_bot.ui.theme.JetpackComposeTheme

@Composable
fun GooglePhotosLogo(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.padding(12.dp).size(300.dp)) {


        drawArc(
            color = Color.Blue,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(
                size.width.div(2f),
                size.height.times(0.25f)
            ),
            size  = Size(
                size.width.div(2f),
                size.height.div(2f)
            )
        )

        drawArc(
            color = Color.Red,
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(
                size.width.times(0.25f),
                0f
            ),
            size  = Size(
                size.width.div(2f),
                size.height.div(2f)
            )
        )

        drawArc(
            color = Color.Green,
            startAngle = -180f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(
                0f,
                size.height.times(0.25f)
            ),
            size  = Size(
                size.width.div(2f),
                size.height.div(2f)
            )
        )

        drawArc(
            color = Color.Yellow,
            startAngle = 90f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(
                size.width.div(4f),
                size.height.times(0.5f)
            ),
            size  = Size(
                size.width.div(2f),
                size.height.div(2f)
            )
        )
    }
    
}

@Preview(showBackground = true)
@Composable
fun GooglePhotosLogoPreview(){
    JetpackComposeTheme {
        GooglePhotosLogo()
    }
}