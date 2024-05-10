package core.presentation.navigations

sealed class NavigationGraph {
    sealed class SplashGroup(
        val route: String
    ) : NavigationGraph() {
        companion object { const val ROOT_ROUTE = "root_splash" }
        data object Splash : SplashGroup("splash")
    }

    sealed class ExpenseGroup(
        val route: String,
        val objectName: String? = null,
        val objectPath: String? = null
    ) : NavigationGraph() {
        companion object { const val ROOT_ROUTE = "root_expense" }
        data object Home : ExpenseGroup("home")
        data object Detail : ExpenseGroup("detail")
    }

    sealed class SettingGroup(
        val route: String,
        val objectName: String? = null,
        val objectPath: String? = null
    ) {
        companion object { const val ROOT_ROUTE = "root_setting" }
        data object Setting : SettingGroup("setting")
    }
}