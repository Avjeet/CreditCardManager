package com.example.creditcardmanager

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Debashish Datt on 21/02/25
 */

@Composable
fun MyCards(onCardClick: (String) -> Unit = {}) {
    val cards = remember {
        AllCreditCardDetails.myCard.map { it.name }
    }

    val recommendedCards = remember { listOf("Premium Bank Platinum", "Elite Gold Rewards", "Silver Cashback Plus") }

    val map: Map<String, String> = mapOf(
        "Premium Bank Platinum" to "Premium_Bank_Platinum",
        "Elite Gold Rewards" to "Elite_Gold_Rewards",
        "Silver Cashback Plus" to "Silver_Cashback_Plus"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "My Cards",
                modifier = Modifier
                    .padding(bottom = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // White text for dark theme
            )
            DashedLine()
        }
        items(cards) { bankName ->
            CreditCardItem(bankName) { name ->
                onCardClick(name)
            }
        }

        item {
            Text(
                text = "Recommended Cards for You",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            DashedLine()
        }
        items(recommendedCards) { cardName ->
            val context = LocalContext.current
            CreditCardItem(cardName) { name ->
//                onCardClick(map[name] ?: "")
                val url = AllCreditCardDetails.allCcDetails.firstOrNull { it.name == map[name] }?.url
                url?.let {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun CreditCardItem(bankName: String, onClick: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xFF1E88E5), // Blue card background
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick(bankName) }
    ) {
        Box(modifier = Modifier) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = bankName,
                    color = Color.White, // White text for dark theme
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun DashedLine() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        val dashWidth = 10.dp.toPx()
        val gapWidth = 5.dp.toPx()
        val pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(dashWidth, gapWidth),
            phase = 0f
        )
        drawLine(
            color = Color.Gray, // Gray color for dashed line in dark theme
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = 2.dp.toPx(),
            pathEffect = pathEffect
        )
    }
}

data class CreditCard(val bankName: String)