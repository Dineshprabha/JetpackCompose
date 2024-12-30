package com.dinesh.jetpackcompose.canvas

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinesh.jetpackcompose.gemini_chat_bot.ui.theme.JetpackComposeTheme

@Composable
fun NextLearnLogo(modifier: Modifier = Modifier) {
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Text(text = "Next Learn", color = Color.Blue)
    }



    Canvas(modifier = modifier
        .padding(12.dp)
        .size(400.dp)){


        val boltPath = Path().apply {
            moveTo(size.width.times(0.14f), size.height.times(0.6f))
            lineTo(size.width.times(0.6f), size.height.times(0.34f))
            lineTo(size.width.times(0.4f), size.height.times(0.74f))
            lineTo(size.width.times(0.4f), size.height.times(0.74f))
            lineTo(size.width.times(0.3f), size.height.times(0.68f))
            lineTo(size.width.times(0.6f), size.height.times(0.34f))
            lineTo(size.width.times(0.25f), size.height.times(0.66f))
//            lineTo(size.width.times(0.15f), size.height.times(0.6f))
            close()
        }

        val tailPath = Path().apply {
            moveTo(size.width.times(0.25f), size.height.times(0.66f))
            lineTo(size.width.times(0.26f), size.height.times(0.75f))
            lineTo(size.width.times(0.3f), size.height.times(0.68f))
        }

        val tailPath1 = Path().apply {
            moveTo(size.width.times(0.34f), size.height.times(0.7f))
            lineTo(size.width.times(0.26f), size.height.times(0.76f))
        }

        
        drawPath(
            path = boltPath,
            color = Color.Blue,
            style = Stroke(10f)
        )

        drawPath(
            path = tailPath,
            color = Color.Blue,
            style = Stroke(10f)
        )

        drawPath(
            path = tailPath1,
            color = Color.Blue,
            style = Stroke(10f)
        )

        val paint = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 80f
            color = Color.Blue.toArgb()
        }

        drawContext.canvas.nativeCanvas.drawText(
            "Next Learn", center.x-180, center.y+380, paint
        )
    }

}

@Preview(showBackground = true)
@Composable
fun NextLearnLogoPreview(){
    JetpackComposeTheme {
        NextLearnLogo()
    }
}