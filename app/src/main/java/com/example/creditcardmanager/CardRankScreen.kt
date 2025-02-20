import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardRankScreen() {
    var selectedCategory by remember { mutableStateOf("Petrol") }
    val categories = listOf("Movies", "Flights", "Hotels")
    val cardsData = mapOf(
        "Movies" to listOf(
            CreditCard("PVR Kotak Card", "10% Cashback", "₹1500 Minimum Spend", "+12% Benefits"),
            CreditCard("ICICI Movie Card", "8% Cashback", "₹1200 Minimum Spend", "+10% Benefits")
        ),
        "Flights" to listOf(
            CreditCard("Axis Travel Card", "7% Cashback", "₹2000 Minimum Spend", "+15% Benefits"),
            CreditCard("Amex Platinum Travel", "6% Cashback", "₹2500 Minimum Spend", "+20% Benefits")
        ),
        "Hotels" to listOf(
            CreditCard("Taj SBI Card", "12% Cashback", "₹3000 Minimum Spend", "+18% Benefits"),
            CreditCard("HDFC StayMax", "10% Cashback", "₹2500 Minimum Spend", "+15% Benefits")
        )
    )

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF121212))) {
        Text(
            text = "Credit Cards",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

        CategoryTabs(categories, selectedCategory) { selectedCategory = it }

        cardsData[selectedCategory]?.forEach { card ->
            CreditCardItem(card)
        }
    }
}

@Composable
fun CategoryTabs(categories: List<String>, selected: String, onSelect: (String) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        categories.forEach { category ->
            TextButton(onClick = { onSelect(category) }) {
                Text(
                    text = category,
                    fontSize = 16.sp,
                    color = if (category == selected) Color.Cyan else Color.White
                )
            }
        }
    }
}

@Composable
fun CreditCardItem(card: CreditCard) {
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.DarkGray,
        modifier = Modifier.padding(12.dp).fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = card.name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = card.cashback, fontSize = 14.sp, color = Color.Green)
            Text(text = card.minSpend, fontSize = 12.sp, color = Color.LightGray)
            Text(text = card.benefit, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Green)
        }
    }
}

data class CreditCard(val name: String, val cashback: String, val minSpend: String, val benefit: String)
