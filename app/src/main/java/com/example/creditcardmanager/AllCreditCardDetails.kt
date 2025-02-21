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
            ),
            url = "https://www.icicibank.com/credit-cards/amazon-pay"
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
            ),
            url = "https://www.axisbank.com/retail/cards/credit-card/axis-airtel-credit-card"
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
            ),
            url = "https://www.idfcfirstbank.com/credit-cards/wow-credit-card"
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
            ),
            url = "https://www.hdfcbank.com/personal/pay/cards/credit-cards/regalia-credit-card"
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
            ),
            url = "https://www.sbicard.com/en/personal/credit-cards/rewards/sbi-prime-card.page"
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
            ),
            url = "https://www.americanexpress.com/in/credit-cards/membership-rewards-card/"
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
            ),
            url = "https://www.bobfinancial.com/eterna-credit-card.jsp"
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
            ),
            url = "https://www.kotak.com/en/personal-banking/cards/credit-cards/kotak-811-credit-card.html"
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
            ),
            url = "https://www.yesbank.in/personal-banking/cards/credit-cards/yes-premia-credit-card"
        ),
        CreditCardDetail(
            name = "Premium_Bank_Platinum",
            title = "Platinum Card",
            type = "Credit Card",
            annualFee = "$99",
            creditLimit = "$10,000",
            fuelSurchargeWaiver = "Yes",
            interestRate = "12%",
            offers = listOf("5% Cashback", "Airport Lounge Access"),
            url = "https://www.premiumbank.com/platinum-card"
        ),
        CreditCardDetail(
            name = "Elite_Gold_Rewards",
            title = "Gold Rewards Card",
            type = "Credit Card",
            annualFee = "$79",
            creditLimit = "$7,500",
            fuelSurchargeWaiver = "Yes",
            interestRate = "14%",
            offers = listOf("2x Points on Dining", "Travel Insurance"),
            url = "https://www.elitebank.com/gold-rewards-card"
        ),
        CreditCardDetail(
            name = "Silver_Cashback_Plus",
            title = "Cashback Card",
            type = "Credit Card",
            annualFee = "$49",
            creditLimit = "$5,000",
            fuelSurchargeWaiver = "No",
            interestRate = "16%",
            offers = listOf("1.5% Cashback", "No Annual Fee First Year"),
            url = "https://www.silverbank.com/cashback-card"
        )

    )
}