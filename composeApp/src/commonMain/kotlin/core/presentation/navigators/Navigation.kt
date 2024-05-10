package core.presentation.navigators

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
import loggings.Logger
import moe.tlaster.precompose.molecule.producePresenter
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo
import moe.tlaster.precompose.navigation.RouteBuilder
import org.koin.compose.koinInject

@Composable
fun Navigation(
    navigator: Navigator,
    // ViewModel
) {
    NavHost(
        navigator = navigator,
        initialRoute = NavigationItems.Splash.route
    ) {
        authGraph(navigator)
        expenseGraph(navigator)
    }
}

private fun RouteBuilder.authGraph(navigator: Navigator) {
    scene(
        route = NavigationItems.Splash.route
    ) {
        SplashScreen(onNextScreenNavigate = {
            navigator.navigate(
                route = NavigationItems.Home.route,
                options = NavOptions(
                    popUpTo = PopUpTo(
                        route = NavigationItems.Splash.route,
                        inclusive = true
                    )
                )
            )
        })
    }
}

private fun RouteBuilder.expenseGraph(navigator: Navigator) {
    scene(
        route = NavigationItems.Home.route,
        swipeProperties = swipeLikeIOS(),
        navTransition = swipeAnimationIOS()
    ) {
        val presenter by producePresenter { SplashPresenter(logger = koinInject<Logger>()) }

        LaunchedEffect(presenter.count) {
            delay(1000)
            presenter.onAction(SplashAction.UpdateCount)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                navigator.navigate(NavigationItems.Details.route)
            }) { Text("Go To Details ${presenter.count}") }
            Button(onClick = {
                navigator.popBackStack()
            }) { Text("Go Back") }
        }
    }
    scene(
        route = NavigationItems.Details.route,
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