package com.example.creditcardmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.creditcardmanager.ui.theme.ChatScreen
import com.example.creditcardmanager.ui.theme.CreditCardManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CreditCardManagerTheme {
                   MainGraph()
            }
        }
    }
}

@Composable
fun OtherTextScreen() {
    // Display some other text
    Text(
        text = "This is some other text.",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(16.dp)
    )
}

// Define a sealed class for the screens
sealed class Screen(val route: String) {
    object TabOne : Screen("tabOne")
    object TabTwo : Screen("tabTwo")
    object TabThree : Screen("tabThree")
}

sealed class MainScreen(val route: String) {
    object ScreenOne : MainScreen("screenOne")
    object ScreenTwo : MainScreen("screenTwo")
    object OnboardingScreen: MainScreen("onboardingScreen")
}

@Preview(showBackground = true)
@Composable
fun PreviewTabNavigationApp() {
    MainGraph()
}
