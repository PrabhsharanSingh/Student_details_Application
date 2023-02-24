package com.example.studentdiary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.studentdiary.ui.theme.StudentDetailsColor
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController) {
    LaunchedEffect(key1 = true){
        delay(500)
        navController.popBackStack()
        navController.navigate(Login.route)
    }
    SplashScreen()
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(StudentDetailsColor.cloud),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(0.5f),
            painter = painterResource(id = R.drawable.ic_action_splash),
            contentDescription = "Login Image",
            colorFilter = ColorFilter.tint(StudentDetailsColor.blue)
        )
    }
}
