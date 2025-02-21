package com.example.creditcardmanager

/**
 * Created by Debashish Datt on 21/02/25
 */
data class CreditCardDetail(
    val name: String,
    val title: String,
    val type: String,
    val annualFee: String,
    val creditLimit: String,
    val fuelSurchargeWaiver: String,
    val interestRate: String,
    val offers: List<String>,
    val url: String
)
