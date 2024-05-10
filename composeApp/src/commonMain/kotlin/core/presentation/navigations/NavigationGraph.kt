package core.presentation.navigations

sealed class NavigationGraph {
    sealed class InitialGroup(
        val route: String
    ) : NavigationGraph() {
        companion object { const val ROOT_ROUTE = "initial" }
        data object Splash : InitialGroup("splash")
    }

    sealed class ExpenseGroup(
        val route: String,
        val objectName: String? = null,
        val objectPath: String? = null
    ) : NavigationGraph() {
        companion object { const val ROOT_ROUTE = "expense" }
        data object Home : ExpenseGroup("home")
        data object Detail : ExpenseGroup("detail")
    }
}