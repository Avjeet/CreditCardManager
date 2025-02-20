package com.example.creditcardmanager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Debashish Datt on 21/02/25
 */

@Composable
fun CardScreen(creditCardDetail: CreditCardDetail?) {
    if(creditCardDetail == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("error")
        }
        return
    }
    CreditCardDetailsScreen(creditCardDetail)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditCardDetailsScreen(creditCardDetail: CreditCardDetail) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Credit Card Details") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CreditCardInfoCard(creditCardDetail)
        }
    }
}

@Composable
fun CreditCardInfoCard(creditCardDetail: CreditCardDetail) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E88E5)), // Blue background
        modifier = Modifier.fillMaxWidth(
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Card Header
            Text(creditCardDetail.title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

            // Details
            CardDetailRow("Card Type", creditCardDetail.type)
            CardDetailRow("Annual Fee", creditCardDetail.annualFee)
            CardDetailRow("Credit Limit", creditCardDetail.creditLimit)
            CardDetailRow("Fuel Surcharge Waiver", creditCardDetail.fuelSurchargeWaiver)
            CardDetailRow("Interest Rate", creditCardDetail.interestRate)

            Text(
                "Offers:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            CashbackOffersList(creditCardDetail.offers)

        }
    }
}

@Composable
fun CardDetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White)
        Text(value, fontSize = 16.sp, fontWeight = FontWeight.Light, color = Color.White)
    }
}

@Composable
fun CashbackOffersList(offers: List<String>) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        offers.forEach { offer ->
            Text("• $offer", fontSize = 14.sp, color = Color.White)
        }
    }
}