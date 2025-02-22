package com.example.creditcardmanager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Created by Debashish Datt on 21/02/25
 */

data class UserSelection(
    val selectedCards: List<String>,
    val selectedIncome: String,
    val esteemedSpending: String
)

@Composable
fun OnboardingScreen(
    onSubmit: (UserSelection) -> Unit
) {
    val incomeOptions = listOf("Below 3L", "3L-6L", "6L-10L", "10L+")
    val spendingOptions = listOf("Below 1L", "1L-3L", "3L-6L", "6L+")

    var selectedIncome by remember { mutableStateOf(incomeOptions.first()) }
    var selectedSpending by remember { mutableStateOf(spendingOptions.first()) }
    var selectedCards by remember { mutableStateOf(emptyList<String>()) }
    var cardDropdownExpanded by remember { mutableStateOf(false) }
    var incomeDropdownExpanded by remember { mutableStateOf(false) }
    var spendingDropdownExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Credit Card Dropdown
        Text(text = "Choose Credit Card", fontWeight = FontWeight.Bold, color = Color.White)
        Box {
            Button(onClick = { cardDropdownExpanded = true }) {
                Text("+ Add Credit Card")
            }
            DropdownMenu(expanded = cardDropdownExpanded, onDismissRequest = { cardDropdownExpanded = false }) {
                AllCreditCardDetails.allCcDetails.forEach { card ->
                    DropdownMenuItem(
                        text = { Text(card.title) },
                        onClick = {
                            if (!selectedCards.contains(card.name)) {
                                selectedCards = selectedCards + card.name
                            }
                            cardDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Display Selected Cards with Remove Option
        selectedCards.forEach { card ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = card, modifier = Modifier.weight(1f), color = Color.White)
                IconButton(onClick = { selectedCards = selectedCards - card }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Remove Card", tint = Color.White)
                }
            }
        }

        // Select Income
        Text(text = "Select Income", color = Color.White)
        Box {
            Button(onClick = { incomeDropdownExpanded = true }) {
                Text(selectedIncome)
            }
            DropdownMenu(expanded = incomeDropdownExpanded, onDismissRequest = { incomeDropdownExpanded = false }) {
                incomeOptions.forEach { income ->
                    DropdownMenuItem(
                        text = { Text(income) },
                        onClick = {
                            selectedIncome = income
                            incomeDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Select Esteemed Spending
        Text(text = "Select Esteemed Spending", color = Color.White)
        Box {
            Button(onClick = { spendingDropdownExpanded = true }) {
                Text(selectedSpending)
            }
            DropdownMenu(expanded = spendingDropdownExpanded, onDismissRequest = { spendingDropdownExpanded = false }) {
                spendingOptions.forEach { spending ->
                    DropdownMenuItem(
                        text = { Text(spending) },
                        onClick = {
                            selectedSpending = spending
                            spendingDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Submit Button
        Button(
            onClick = {
                val userSelection = UserSelection(
                    selectedCards = selectedCards,
                    selectedIncome = selectedIncome,
                    esteemedSpending = selectedSpending
                )
                println("Saved: $userSelection") // Handle saving logic
                onSubmit(userSelection)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}