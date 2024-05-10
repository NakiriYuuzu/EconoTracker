package core.presentation.navigations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.presentation.splash.SplashAction
import core.presentation.splash.SplashPresenter
import core.presentation.splash.SplashScreen
import kotlinx.coroutines.delay
import logging.Logger
import moe.tlaster.precompose.molecule.producePresenter
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo
import moe.tlaster.precompose.navigation.RouteBuilder
import org.koin.compose.koinInject


@Composable
fun Navigation(
    navigator: Navigator
) {
    NavHost(
        navigator = navigator,
        initialRoute = NavigationGraph.InitialGroup.ROOT_ROUTE
    ) {
        initialGraph(navigator)
        expenseGraph(navigator)
    }
}

private fun RouteBuilder.initialGraph(
    navigator: Navigator
) {
    group(
        route = NavigationGraph.InitialGroup.ROOT_ROUTE,
        initialRoute = NavigationGraph.InitialGroup.Splash.route
    ) {
        scene(
            route = NavigationGraph.InitialGroup.Splash.route
        ) {
            SplashScreen(onNextScreenNavigate = {
                navigator.navigate(
                    route = NavigationGraph.ExpenseGroup.Home.route,
                    options = NavOptions(
                        popUpTo = PopUpTo(
                            route = NavigationGraph.ExpenseGroup.Home.route,
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
        scene(
            route = NavigationGraph.ExpenseGroup.Home.route,
            swipeProperties = swipeLikeIOS(),
            navTransition = swipeAnimationIOS()
        ) {
            val presenter by producePresenter { SplashPresenter(koinInject<Logger>()) }

            LaunchedEffect(presenter.count) {
                try {
                    delay(1000)
                    presenter.onAction(SplashAction.UpdateCount)
                }catch (e: Exception) {
                    println(e.message)
                }
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    navigator.navigate(NavigationGraph.ExpenseGroup.Detail.route)
                }) { Text("Go To Details ${presenter.count}") }
                Button(onClick = {
                    navigator.popBackStack()
                }) { Text("Go Back") }
            }
        }
        scene(
            route = NavigationGraph.ExpenseGroup.Detail.route,
            swipeProperties = swipeLikeIOS(),
            navTransition = swipeAnimationIOS()
        ) {
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