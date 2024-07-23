package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import core.presentation.expense.home.HomeScreenRoot
import core.presentation.setting.SettingScreenRoot
import core.presentation.splash.SplashScreen

@Composable
fun EconoGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = SplashGroup
    ) {
        initialGraph(navController)
        expenseGraph(navController)
        settingGraph(navController)
    }
}


private fun NavGraphBuilder.initialGraph(
    navController: NavController
) {
    navigation<SplashGroup>(
        startDestination = SplashGroup.SplashScreen,
    ) {
        composable<SplashGroup.SplashScreen> {
            SplashScreen(
                onNextScreenNavigate = {
                    navController.navigate(ExpenseGroup) {
                        launchSingleTop = true
                        popUpTo(SplashGroup) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.expenseGraph(
    navController: NavController
) {
    navigation<ExpenseGroup>(
        startDestination = ExpenseGroup.HomeScreen,
    ) {
        composable<ExpenseGroup.HomeScreen> {
            HomeScreenRoot(
                onSettingClick = {
                    navController.navigate(SettingGroup)
                }
            )
        }
    }
}

private fun NavGraphBuilder.settingGraph(
    navController: NavController
) {
    navigation<SettingGroup>(
        startDestination = SettingGroup.SettingScreen,
    ) {
        composable<SettingGroup.SettingScreen> {
            SettingScreenRoot(
                onBackClicked = {
                    navController.navigateUp()
                }
            )
        }
    }
}