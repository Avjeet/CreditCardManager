package com.example.creditcardmanager

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

/**
 * Created by Debashish Datt on 21/02/25
 */

@Composable
fun MainGraph() {
    val mainNavController = rememberNavController()
    Scaffold { innerPadding ->
        // Setting up the navigation graph
        NavHost(
            navController = mainNavController,
            startDestination = MainScreen.OnboardingScreen.route,
            modifier = Modifier.padding( bottom = innerPadding.calculateBottomPadding())
        ) {
            composable(MainScreen.ScreenOne.route) {
                TabNavigationApp(mainNavController)
            }
            composable(
                route = "${MainScreen.ScreenTwo.route}/{name}",  // Route with argument
                arguments = listOf(navArgument("name") { defaultValue = "Default Message" })
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: "No name"
                val creditCardDetail = AllCreditCardDetails.allCcDetails.filter { it ->
                    name == it.name
                }.firstOrNull()
                CardScreen(creditCardDetail)
                // Tab 1 - Hello World screen

            }
            composable(MainScreen.OnboardingScreen.route) {
                OnboardingScreen { userSelection ->
                    userSelection.selectedCards.forEach {
                        val cc =
                            AllCreditCardDetails.allCcDetails.firstOrNull { cc -> it == cc.name }
                        cc?.let { nonNullCC ->
                            AllCreditCardDetails.myCard.add(nonNullCC)
                        }
                    }
                    AllCreditCardDetails.income = userSelection.selectedIncome
                    mainNavController.navigate(MainScreen.ScreenOne.route)
                }
            }
        }
    }
}