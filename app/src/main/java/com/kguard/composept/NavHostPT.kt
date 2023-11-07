package com.kguard.composept

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kguard.composept.ui.ui.Greetings
import com.kguard.composept.ui.ui.OnboardingScreen


@Composable
fun NavHostPT(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Onboarding.route,
        modifier = modifier
    ) {
        composable(Onboarding.route) {
            OnboardingScreen(
                onContinuedClicked = { text ->
                    navController.navToGreeting(text)
                },
                modifier = modifier,
            )
        }
        composable(
            Greetings.routeWithArgs,
            arguments = Greetings.arguments
        ) { navBackStackEntry ->
            val text = navBackStackEntry.arguments?.getString(Greetings.arg)
            Greetings(onBack = { navController.popBackStack() }, modifier = modifier, texts = text)
        }
    }
}

fun NavHostController.navToGreeting(text: String?) {
    this.navigate("${Greetings.route}/$text")
}