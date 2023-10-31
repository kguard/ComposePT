package com.kguard.composept

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kguard.composept.ui.theme.ComposePTTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePTTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    // .value 붙여야함
//    val expanded = remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        label = "extraPadding",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    //val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(20))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(onClick = { expanded = !expanded }) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }

}

@Composable
fun ClickCounter(clicks: MutableState<Int>, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick, modifier = Modifier
            .clip(CircleShape)
            .padding(vertical = 8.dp)
    ) {
        Text("I've been clicked ${clicks.value} times")
    }

}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    val names: List<String> = listOf("kim", "Lee")
    val count = remember {
        mutableStateOf(0)
    }
    ComposePTTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            for (name in names)
                Greeting(name)
            //ClickCounter(clicks = count, onClick = { count=count+1 })
        }
    }
}

@Composable
fun OnboardingScreen(onContinuedClicked: () -> Unit, modifier: Modifier = Modifier) {
    // by 키워드는 매번 .value를 입력할 필요가 없도록 해주는 속성 위임입니다. val -> var
    // MyApp으로 올라감
    //var shouldShowOnboarding by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcom to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinuedClicked
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    ComposePTTheme {
        OnboardingScreen({})
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    // remember와 다르게 화면 회전 같은 프로세스 중단에도 상태를 저장 하기 위해서 사용 -> rememberSaveable
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
//    var shouldShowOnboarding by remember { mutableStateOf(true) }
    val names: List<String> = listOf("kim", "Lee")
    Surface() {
//        if (shouldShowOnboarding)
//            OnboardingScreen(onContinuedClicked = {shouldShowOnboarding = false})
//        else
//            //실헹 안됨
//            Greetings(onClick = {shouldShowOnboarding=true})
        when (shouldShowOnboarding) {
            true -> OnboardingScreen(onContinuedClicked = { shouldShowOnboarding = false })
            else -> Greetings(onClick = { shouldShowOnboarding = true })
        }
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" },
    onClick: () -> Unit
) {
//    Column(modifier = modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name)
//        }
//        Button(modifier = modifier.padding(horizontal = 8.dp),onClick = { onClick }) {
//            Text("To True")
//
//        }
//    }
    // 참고: LazyColumn과 LazyRow는 Android 뷰의 RecyclerView와 동일합니다.
    Column(modifier) {
        Button(onClick = { /*TODO*/ },modifier.padding(horizontal = 8.dp)) {
            Text("back")
        }
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                Greeting(name = name)
            }
        }
    }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingsPreview() {
    ComposePTTheme {
        Greetings(onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    ComposePTTheme {
        MyApp(Modifier.fillMaxSize())
    }
}
