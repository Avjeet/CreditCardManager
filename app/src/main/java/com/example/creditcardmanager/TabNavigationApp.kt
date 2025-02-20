package com.example.creditcardmanager

import CardRankScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.creditcardmanager.ui.theme.ChatScreen

@Composable
fun TabNavigationApp() {
    val navController = rememberNavController()  // Create Navigation Controller

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        // Setting up the navigation graph
        NavHost(
            navController = navController,
            startDestination = Screen.TabOne.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.TabOne.route) {
                // Tab 1 - Hello World screen
                ChatScreen()
            }
            composable(Screen.TabTwo.route) {
                // Tab 2 - Some other text screen
                CardRankScreen()
            }
        }
    }
}