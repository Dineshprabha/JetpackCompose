package com.dinesh.jetpackcompose.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinesh.jetpackcompose.gemini_chat_bot.ui.theme.JetpackComposeTheme

@Composable
fun FacebookMessengerLogo(modifier: Modifier = Modifier) {

    Canvas(modifier = modifier.padding(12.dp).size(300.dp)) {

        val triangle = Path().apply {
            moveTo(
                size.width.times(0.2f),
                size.height.times(0.84f)
            )
            lineTo(size.width.times(0.2f), size.height.times(0.99f))
            lineTo(size.width.times(0.4f), size.height.times(0.91f))
        }
        drawOval(
            color = Color.Blue,
            size = Size(
                width = size.width,
                height = size.height.times(0.95f)
            )

        )

        val boltPath = Path().apply { 
            moveTo(size.width.times(0.2f), size.height.times(0.6f))
            lineTo(size.width.times(0.45f), size.height.times(0.34f))
            lineTo(size.width.times(0.55f), size.height.times(0.45f))
            lineTo(size.width.times(0.8f), size.height.times(0.33f))
            lineTo(size.width.times(0.55f), size.height.times(0.6f))
            lineTo(size.width.times(0.45f), size.height.times(0.47f))
            close()
        }

        drawPath(
            path = triangle,
            color = Color.Blue,
            style = Fill
        )

        drawPath(
            path = boltPath,
            color = Color.White,
            style = Fill
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FacebookMessengerLogoPreview(){
    JetpackComposeTheme {
        FacebookMessengerLogo()
    }
}