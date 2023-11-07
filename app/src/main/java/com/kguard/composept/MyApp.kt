package com.kguard.composept

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp(modifier: Modifier = Modifier) {
//    // remember와 다르게 화면 회전 같은 프로세스 중단에도 상태를 저장 하기 위해서 사용 -> rememberSaveable
//    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
//    Log.e("tag", "MyApp: recompose $shouldShowOnboarding")
////    var shouldShowOnboarding by remember { mutableStateOf(true) }
//    val names: List<String> = listOf("kim", "Lee")
////    if (shouldShowOnboarding)
////        OnboardingScreen(onContinuedClicked = { shouldShowOnboarding = false })
////    else
////        Greetings(onBack = { shouldShowOnboarding = true })
//    when (shouldShowOnboarding) {
//        true -> OnboardingScreen(onContinuedClicked = { shouldShowOnboarding = false })
//        false -> Greetings(onBack = { shouldShowOnboarding = true })
//    }
    val navController = rememberNavController()
    NavHostPT(navController = navController, modifier = modifier)

}




