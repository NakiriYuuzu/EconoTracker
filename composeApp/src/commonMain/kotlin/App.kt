import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import core.data.source.local.AppDatabase
import core.domain.model.Category
import core.domain.model.Expense
import core.presentation.navigations.Navigation
import logging.Logger
import org.jetbrains.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import theme.EconoTheme
import util.LocalSettingState
import util.LocalWindowSizeClass
import util.toColor

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
@Preview
fun App() {
    KoinContext {
        PreComposeApp {
            val viewModel = koinViewModel(MainViewModel::class)
            val state by viewModel.state.collectAsStateWithLifecycle()
            val database = koinInject<AppDatabase>()
            val logger = koinInject<Logger>()

            LaunchedEffect(Unit) {
                val category = Category(
                    name = "Food",
                    icon = "food"
                )
                val expense = Expense(
                    date = 0,
                    type = "Expense",
                    amount = 0.0,
                    category = 1,
                    description = "Description",
                    paymentMethod = "Payment Method"
                )
                database.categoryDao().upsert(category)
                database.expenseDao().upsert(expense)
                database.categoryDao().getCategories().collect {
                    it.forEach { category ->
                        logger.e("Category") { category.toString() }
                    }
                }
                database.expenseDao().getAllExpenses().collect {
                    it.forEach { expense ->
                        logger.e("Expense") { expense.toString() }
                    }
                }
            }

            CompositionLocalProvider(
                LocalWindowSizeClass provides calculateWindowSizeClass(),
                LocalSettingState provides state
            ) {
                val navigator = rememberNavigator()

                EconoTheme(
                    seedColor = state.themeColor.toColor(),
                    themeMode = state.themeMode
                ) {
                    Navigation(
                        navigator = navigator
                    )
                }
            }
        }
    }
}