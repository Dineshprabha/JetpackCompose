package com.dinesh.jetpackcompose.canvas

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinesh.jetpackcompose.gemini_chat_bot.ui.theme.JetpackComposeTheme

@Composable
fun FacebookLogo(modifier: Modifier = Modifier) {


    Canvas(modifier = modifier.padding(12.dp).size(300.dp)) {

        val paint = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 860f
            color = Color.White.toArgb()
        }
        drawRoundRect(
            color = Color.Blue,
            cornerRadius = CornerRadius(x = 120f, y = 120f)
        )

        drawContext.canvas.nativeCanvas.drawText(
            "f", center.x+100, center.y+320, paint
        )

    }
}

@Preview(showBackground = true)
@Composable
fun FacebookLogoPreview(){
    JetpackComposeTheme {
        FacebookLogo()
    }
}