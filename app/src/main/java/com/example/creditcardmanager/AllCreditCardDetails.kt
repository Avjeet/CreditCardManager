package com.example.creditcardmanager

/**
 * Created by Debashish Datt on 21/02/25
 */

object AllCreditCardDetails {
    var income: String? = null

    var myCard: MutableList<CreditCardDetail> = mutableListOf()
    val allCcDetails = listOf(
        CreditCardDetail(
            name = "ICICI_AmazonPay",
            title = "ICICI Amazon Pay Credit Card",
            type = "VISA",
            annualFee = "Free",
            creditLimit = "3.10L",
            fuelSurchargeWaiver = "1% fuel surcharge waiver",
            interestRate = "3.50%",
            offers = listOf(
                "5% cashback on Amazon purchases",
                "5% on flight/hotel bookings",
                "1% on international spends",
                "2% on Amazon Pay partner merchants",
                "20% cashback on electricity bill",
                "EazyDiner Prime membership"
            )
        ),
        CreditCardDetail(
            name = "Axis_Airtel",
            title = "Axis Airtel Credit Card",
            type = "Mastercard",
            annualFee = "Rs. 500/- (Waiver on 2L/year spend)",
            creditLimit = "2.25L",
            fuelSurchargeWaiver = "1% fuel surcharge waiver",
            interestRate = "3.50%",
            offers = listOf(
                "25% cashback on Airtel bills (max ₹250/month)",
                "10% cashback on utility bills (max ₹250/month)",
                "10% cashback on Swiggy/Zomato/BigBasket (max ₹500/month)",
                "20% dining discount at partner restaurants"
            )
        ),
        CreditCardDetail(
            name = "IDFC_First_Wow",
            title = "IDFC First Wow Credit Card",
            type = "VISA",
            annualFee = "Free",
            creditLimit = "5L",
            fuelSurchargeWaiver = "No expiry on rewards",
            interestRate = "1.50%",
            offers = listOf(
                "3x rewards on online/offline purchases (up to Rs. 20,000/month)",
                "10x rewards on spends above Rs. 20,000/month",
                "Buy 1 Get 1 Movie Ticket Offer",
                "Airport Spa services (30 min)",
                "4 Railway lounge visits per quarter"
            )
        ),
        CreditCardDetail(
            name = "HDFC_Regalia",
            title = "HDFC Regalia Credit Card",
            type = "VISA",
            annualFee = "Rs. 2,500",
            creditLimit = "4.5L",
            fuelSurchargeWaiver = "1% fuel surcharge waiver",
            interestRate = "3.49%",
            offers = listOf(
                "Complimentary airport lounge access",
                "5x reward points on international spends",
                "2x reward points on dining & travel",
                "1% fuel surcharge waiver"
            )
        ),
        CreditCardDetail(
            name = "SBI_Prime",
            title = "SBI Prime Credit Card",
            type = "Mastercard",
            annualFee = "Rs. 2,999",
            creditLimit = "3.75L",
            fuelSurchargeWaiver = "1% fuel surcharge waiver",
            interestRate = "3.35%",
            offers = listOf(
                "10x reward points on movies & dining",
                "Complimentary Club Vistara Silver Membership",
                "Free domestic lounge access"
            )
        ),
        CreditCardDetail(
            name = "AMEX_Membership",
            title = "American Express Membership Rewards Card",
            type = "AMEX",
            annualFee = "Rs. 1,500",
            creditLimit = "5L",
            fuelSurchargeWaiver = "1% fuel surcharge waiver",
            interestRate = "3.99%",
            offers = listOf(
                "1000 bonus points on transactions over Rs. 1000 (4 times/month)",
                "Fuel surcharge waiver at HPCL outlets",
                "Exclusive travel & dining offers"
            )
        ),
        CreditCardDetail(
            name = "BOB_Eterna",
            title = "Bank of Baroda Eterna Credit Card",
            type = "VISA",
            annualFee = "Rs. 2,499",
            creditLimit = "3.2L",
            fuelSurchargeWaiver = "1% fuel surcharge waiver",
            interestRate = "3.25%",
            offers = listOf(
                "10x reward points on travel, dining & online spends",
                "Free domestic & international lounge access",
                "1% fuel surcharge waiver"
            )
        ),
        CreditCardDetail(
            name = "Kotak_811",
            title = "Kotak 811 Credit Card",
            type = "Mastercard",
            annualFee = "Free",
            creditLimit = "2L",
            fuelSurchargeWaiver = "1% fuel surcharge waiver",
            interestRate = "3.75%",
            offers = listOf(
                "2.5% cashback on online spends",
                "5% cashback on Kotak partner brands",
                "Free railway lounge access"
            )
        ),
        CreditCardDetail(
            name = "YES_Bank_Premia",
            title = "YES Bank Premia Credit Card",
            type = "VISA",
            annualFee = "Rs. 1,599",
            creditLimit = "3.6L",
            fuelSurchargeWaiver = "1% fuel surcharge waiver",
            interestRate = "3.40%",
            offers = listOf(
                "6 domestic lounge visits per year",
                "5% cashback on movie & grocery spends",
                "Accelerated reward points on travel"
            )
        )
    )
}