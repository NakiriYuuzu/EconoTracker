package navigation

import kotlinx.serialization.Serializable

@Serializable
data object SplashGroup {
    @Serializable
    data object SplashScreen
}

@Serializable
data object ExpenseGroup {
    @Serializable
    data object HomeScreen
    @Serializable
    data class DetailScreen(val id: String)
}

@Serializable
data object SettingGroup {
    @Serializable
    data object SettingScreen
}
