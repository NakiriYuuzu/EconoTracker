import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import core.data.source.local.Expense
import core.data.source.local.ExpenseDatabase
import core.presentation.navigations.Navigation
import kotlinx.datetime.Clock
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
            var database = koinInject<ExpenseDatabase>()

            LaunchedEffect(Unit) {
                val expense = Expense(
                    date = Clock.System.now().toEpochMilliseconds(),
                    type = "Test",
                    amount = 100.0,
                    description = "Test",
                    category = "Test",
                    paymentMethod = ""
                )
                database.expenseDao().upsert(
                    expense
                )
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