import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardRankScreen() {
    var selectedCategory by remember { mutableStateOf("Movies") }
    val categories = listOf("Movies", "Flights", "Hotels", "Petrol", "Rewards", "Cashback")
    val cardsData = mapOf(
        "Movies" to listOf(
            CreditCard("PVR Kotak Card", "20% Off on Movie Tickets", "₹1,500 Minimum Spend", "Extra Popcorn Combo", "https://www.kotak.com"),
            CreditCard("ICICI Movie Card", "15% Off on Cinema Tickets", "₹1,200 Minimum Spend", "Exclusive Lounge Access", "https://www.icicibank.com"),
            CreditCard("HDFC Cine Prime", "Buy 1 Get 1 Free on Weekends", "₹1,000 Minimum Spend", "Discounts on Food & Beverages", "https://www.hdfcbank.com"),
            CreditCard("SBI Movie Buff Card", "Flat ₹200 Off on Tickets", "No Minimum Spend", "Free Access to Premier Shows", "https://www.sbi.co.in"),
            CreditCard("Axis Entertainment Card", "5% Cashback on Movie Bookings", "₹1,500 Minimum Spend", "Complimentary OTT Subscription", "https://www.axisbank.com")
        ),
        "Flights" to listOf(
            CreditCard("Axis Travel Card", "10% Discount on Flight Bookings", "₹2,000 Minimum Spend", "Free Airport Lounge Access", "https://www.axisbank.com"),
            CreditCard("IndusInd SkyMiles", "Extra 3,000 Air Miles", "₹2,500 Minimum Spend", "Priority Boarding Benefits", "https://www.indusind.com"),
            CreditCard("HDFC JetPrivilege", "Earn 10X Miles on Flights", "₹3,000 Minimum Spend", "Upgrade to Business Class Offers", "https://www.hdfcbank.com"),
            CreditCard("SBI AirMiles Card", "Flat ₹500 Off on Domestic Flights", "₹1,500 Minimum Spend", "Additional Reward Points on Travel", "https://www.sbi.co.in"),
            CreditCard("Amex Travel Rewards", "Complimentary Travel Insurance", "No Minimum Spend", "Discounts on International Hotels & Flights", "https://www.americanexpress.com")
        ),
        "Hotels" to listOf(
            CreditCard("Taj SBI Card", "15% Cashback on Taj Stays", "₹3,000 Minimum Spend", "Complimentary Breakfast & Room Upgrades", "https://www.sbi.co.in"),
            CreditCard("HDFC Hotel Rewards", "8X Reward Points on Hotel Bookings", "₹2,500 Minimum Spend", "Exclusive Deals on Luxury Resorts", "https://www.hdfcbank.com"),
            CreditCard("ICICI StaySmart Card", "10% Discount on 5-Star Hotels", "₹2,000 Minimum Spend", "Free Late Checkout Option", "https://www.icicibank.com"),
            CreditCard("Axis Luxe Hotel Card", "Flat 12% Off on International Hotels", "₹2,000 Minimum Spend", "VIP Concierge Services", "https://www.axisbank.com"),
            CreditCard("Marriott Bonvoy HDFC Credit Card", "Earn Free Night Stays", "No Minimum Spend", "Extra Reward Points on Marriott Hotels", "https://www.hdfcbank.com")
        ),
        "Petrol" to listOf(
            CreditCard("BPCL SBI Card", "5% Cashback on Fuel", "₹1,000 Minimum Spend", "1% Fuel Surcharge Waiver", "https://www.sbi.co.in"),
            CreditCard("IndianOil Citi Card", "4% Cashback on IndianOil Fuel", "No Minimum Spend", "Bonus Reward Points on Every Refuel", "https://www.online.citibank.co.in"),
            CreditCard("HP Payback Card", "Extra ₹200 Cashback Monthly", "₹1,500 Minimum Spend", "Exclusive Fuel Savings Program", "https://www.hdfcbank.com"),
            CreditCard("HDFC Fuel Advantage", "Save ₹500 per Month on Fuel", "₹2,000 Minimum Spend", "Instant Discount on Petrol Pumps", "https://www.hdfcbank.com"),
            CreditCard("Axis Drive Card", "Special Fuel Discounts & Free Services", "₹1,000 Minimum Spend", "Additional Perks on Car Maintenance", "https://www.axisbank.com")
        ),
        "Rewards" to listOf(
            CreditCard("HDFC Infinia", "6X Reward Points on Every Spend", "No Minimum Spend", "Complimentary Lounge Access", "https://www.hdfcbank.com"),
            CreditCard("Axis Magnus", "3X Reward Points on Travel & Dining", "₹2,500 Minimum Spend", "Premium Rewards & Offers", "https://www.axisbank.com"),
            CreditCard("SBI Reward Plus", "4X Points on Shopping", "₹1,000 Minimum Spend", "Exclusive Shopping Benefits", "https://www.sbi.co.in"),
            CreditCard("ICICI Smart Rewards", "5% Cashback on Retail Purchases", "₹1,500 Minimum Spend", "Bonus Points on Online Shopping", "https://www.icicibank.com"),
            CreditCard("Kotak Privilege Card", "Earn 5X Points on Every Spend", "No Minimum Spend", "Luxury Brand Discounts", "https://www.kotak.com")
        ),
        "Cashback" to listOf(
            CreditCard("Flipkart Axis Bank Credit Card", "Unlimited 5% Cashback on Flipkart", "No Minimum Spend", "1.5% Cashback on All Purchases", "https://www.axisbank.com"),
            CreditCard("Amazon Pay ICICI Credit Card", "Flat 5% Cashback on Amazon Shopping", "No Minimum Spend", "1% Cashback on Other Spends", "https://www.icicibank.com"),
            CreditCard("HDFC Cashback Card", "5% Cashback on Online Purchases", "₹1,000 Minimum Spend", "Special Discounts on Partner Brands", "https://www.hdfcbank.com"),
            CreditCard("SBI Cashback Platinum", "4% Cashback on Retail & Grocery", "₹2,000 Minimum Spend", "Extra Cashback on Dining", "https://www.sbi.co.in"),
            CreditCard("ICICI Instant Cashback", "2% Cashback on Utility Bills & More", "₹1,500 Minimum Spend", "No Annual Fees, Instant Savings", "https://www.icicibank.com")
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Text(
            text = "Top Categories",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

        CategoryTabs(categories, selectedCategory) { selectedCategory = it }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(cardsData[selectedCategory] ?: emptyList()) { card ->
                CreditCardItem(card)
            }
        }
    }
}

@Composable
fun CategoryTabs(categories: List<String>, selected: String, onSelect: (String) -> Unit) {
    LazyRow(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        items(categories) { category ->
            TextButton(onClick = { onSelect(category) }) {
                Text(
                    text = category,
                    fontSize = 16.sp,
                    color = if (category == selected) Color.Cyan else Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@Composable
fun CreditCardItem(card: CreditCard) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.DarkGray,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(card.url))
                context.startActivity(intent)
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = card.name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = card.cashback, fontSize = 14.sp, color = Color.Green)
            Text(text = card.minSpend, fontSize = 12.sp, color = Color.LightGray)
            Text(text = card.benefit, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Green)
        }
    }
}

data class CreditCard(val name: String, val cashback: String, val minSpend: String, val benefit: String, val url: String)
