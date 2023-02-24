package com.example.studentdiary

interface Destinations {
    val route: String
}

object Login: Destinations {
    override val route = "Login"
}

object Splash: Destinations {
    override val route = "Splash"
}

object Home: Destinations {
    override val route = "Home"
}

object Profile: Destinations {
    override val route = "Profile"
}

object FeesPaid: Destinations {
    override val route = "FeesPaid"
}