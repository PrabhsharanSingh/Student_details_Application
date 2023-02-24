package com.example.studentdiary

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.studentdiary.ui.theme.StudentDiaryTheme

var startDestination: String = Splash.route
var currentRoute: String? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentDiaryTheme {
                MyNavigation()
            }
        }
    }
    override fun onDestroy() {
        when(currentRoute){
            Home.route -> startDestination = Home.route
            Login.route -> startDestination = Splash.route
        }
        super.onDestroy()
    }
}

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){
        composable(Splash.route) {
            Splash(navController)
        }
        composable(Login.route){
            LoginScreen(navController)
        }
        composable(Home.route){
            HomeScreen(navController)
        }
        composable(Profile.route){
            ProfileScreen(navController)
        }
        composable(FeesPaid.route){
            FeesPaidScreen(navController)
        }
    }
    currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
}
