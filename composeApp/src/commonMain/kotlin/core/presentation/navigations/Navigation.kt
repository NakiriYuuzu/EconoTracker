package core.presentation.navigations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.presentation.expense.home.HomeScreen
import core.presentation.setting.SettingScreenRoot
import core.presentation.splash.SplashScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.SwipeProperties

@Composable
fun Navigation(navigator: Navigator) {
    NavHost(
        navigator = navigator,
        initialRoute = NavigationGraph.SplashGroup.ROOT_ROUTE,
        navTransition = swipeAnimationIOS(),
        swipeProperties = SwipeProperties(spaceToSwipe = 100.dp)
    ) {
        initialGraph(navigator)
        expenseGraph(navigator)
        settingGraph(navigator)
    }
}

private fun RouteBuilder.initialGraph(
    navigator: Navigator
) {
    group(
        route = NavigationGraph.SplashGroup.ROOT_ROUTE,
        initialRoute = NavigationGraph.SplashGroup.Splash.route
    ) {
        scene(route = NavigationGraph.SplashGroup.Splash.route) {
            SplashScreen(onNextScreenNavigate = {
                navigator.navigate(
                    route = NavigationGraph.ExpenseGroup.ROOT_ROUTE,
                    options = NavOptions(
                        popUpTo = PopUpTo(
                            route = NavigationGraph.SplashGroup.ROOT_ROUTE,
                            inclusive = true
                        )
                    )
                )
            })
        }
    }
}

private fun RouteBuilder.expenseGraph(
    navigator: Navigator
) {
    group(
        route = NavigationGraph.ExpenseGroup.ROOT_ROUTE,
        initialRoute = NavigationGraph.ExpenseGroup.Home.route
    ) {
        scene(route = NavigationGraph.ExpenseGroup.Home.route) {
            HomeScreen(
                onSettingClick = {
                    navigator.navigate(route = NavigationGraph.SettingGroup.ROOT_ROUTE)
                }
            )
        }
        scene(route = NavigationGraph.ExpenseGroup.Detail.route) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    navigator.popBackStack()
                }) { Text("Go Back") }
            }
        }
    }
}

private fun RouteBuilder.settingGraph(navigator: Navigator) {
    group(
        route = NavigationGraph.SettingGroup.ROOT_ROUTE,
        initialRoute = NavigationGraph.SettingGroup.Setting.route
    ) {
        scene(route = NavigationGraph.SettingGroup.Setting.route) {
            SettingScreenRoot(
                onBackClicked = {
                    navigator.popBackStack()
                }
            )
        }
    }
}