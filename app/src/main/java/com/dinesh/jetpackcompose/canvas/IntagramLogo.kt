package com.dinesh.jetpackcompose.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinesh.jetpackcompose.gemini_chat_bot.ui.theme.JetpackComposeTheme

@Composable
fun InstagramLogo(modifier: Modifier = Modifier) {

    Canvas(
        modifier = modifier
            .padding(12.dp)
            .size(300.dp)
            .background(brush = Brush.linearGradient(listOf(Red, Blue)))
    ) {
        drawRoundRect(color = Color.White,
            cornerRadius = CornerRadius(x = 120f, y = 120f),
            style = Stroke(width = 36f),
            //to restrict the rectangle to occupy whole canvas
//            size = Size(width = 30f, height = 30f)
            )

        drawCircle(color = Color.White,
            radius = 150f,
            style = Stroke(width = 28f),
        )

        drawCircle(color = Color.White,
            radius = 24f,
            center = Offset(size.width.times(0.8f),
                size.height.times(0.2f))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramLogoPreview() {
    JetpackComposeTheme {
        InstagramLogo()
    }
}