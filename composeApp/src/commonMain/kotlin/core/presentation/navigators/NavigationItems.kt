package core.presentation.navigators

import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItems(
    val route: String,
    val title: String,
    val icon: ImageVector?,
    val data: Any?
) {
    data object Splash : NavigationItems("/splash", "Splash", null, null)
    data object Home : NavigationItems("/home", "Home", null, null)
    data object Details : NavigationItems("/details", "Details", null, null)
}