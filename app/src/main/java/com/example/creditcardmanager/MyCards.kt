package com.example.creditcardmanager

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
import androidx.compose.ui.graphics.Color
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

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(cards) { bankName ->
            CreditCardItem(bankName) { name ->
                onCardClick(name)
            }
        }
    }
}

@Composable
fun CreditCardItem(bankName: String, onClick: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        contentColor = Color(0xFF1E88E5), // Blue card background
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
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}

data class CreditCard(val bankName: String)