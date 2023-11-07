package com.kguard.composept

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface ComposePTDestination {
    val route: String
}

object Greetings : ComposePTDestination {
    override val route = "greetings"
    const val arg = "textc"
    // 루트와 넘겨주는 값 같이 사용
    val routeWithArgs = "$route/{$arg}"
    // 어떤 값을 받아야 하는 지
    val arguments = listOf(navArgument(arg) { type = NavType.StringType })
}

object Onboarding : ComposePTDestination {
    override val route = "onboarding"
}
