package com.dinesh.jetpackcompose.rapido_order_design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinesh.jetpackcompose.R
import com.dinesh.jetpackcompose.gemini_chat_bot.ui.theme.JetpackComposeTheme

@Composable
fun RapidoOrderDisplayScreen(modifier: Modifier = Modifier) {
    TwoLazyColumnsSideBySide()
}

@Composable
fun TwoLazyColumnsSideBySide() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Add space between columns
    ) {
        Column(
            modifier = Modifier
                .width(110.dp) // Fixed width
                .fillMaxHeight()
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f) // Divide the available space equally
                    .fillMaxHeight()
            ) {
                items(10) { index ->
                    OrderItem()
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth() // Fixed width
                .fillMaxHeight()
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f) // Divide the available space equally
                    .fillMaxHeight()
            ) {
                items(10) { index ->
                    OrderDetailsCard()
                }
            }
        }

    }
}

@Composable
fun OrderItem() {
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 90.dp)
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null, modifier = Modifier.size(width = 34.dp, height = 34.dp)
        )

    }
}

@Composable
fun OrderDetailsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Yellow),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_delete_24), // Replace with your icon resource
                    contentDescription = "Delivery Icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(end = 16.dp)
                )
                Text(
                    text = "Order Details",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Pickup Address:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "pickUpAddress",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Delivery Address:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "deliveryAddress",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Delivery Charges: $2.99",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Text("Accept")
                }

                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text("Reject", color = Color.White)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun RapidoOrderDisplayScreenPreview() {
    JetpackComposeTheme {
        RapidoOrderDisplayScreen()
    }
}