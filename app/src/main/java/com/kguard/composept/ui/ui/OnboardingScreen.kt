package com.kguard.composept.ui.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingScreen(onContinuedClicked: (String?) -> Unit, modifier: Modifier = Modifier) {
    // by 키워드는 매번 .value를 입력할 필요가 없도록 해주는 속성 위임입니다. val -> var
    // MyApp으로 올라감
    //var shouldShowOnboarding by remember { mutableStateOf(true) }
    var editText by remember { mutableStateOf("") }
    //
    val error by remember { derivedStateOf { editText.isNotEmpty() } }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Basics CodeLab!")
        OutlinedTextField(
            value = editText,
            onValueChange = { newValue ->
                editText = newValue
            },
            Modifier.padding(vertical = 8.dp),
            label = { Text(text = "Onboarding") },
            singleLine = true,
            placeholder = { Text("Greetings로 넘겨줄 Text") },
        )
        Button(
            modifier = Modifier.padding(vertical = 16.dp),
            onClick = { onContinuedClicked(editText) },
            enabled = error
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevOnboarding() {
    OnboardingScreen({})
}
