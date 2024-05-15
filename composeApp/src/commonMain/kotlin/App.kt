import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import core.presentation.navigations.Navigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinContext
import theme.EconoTheme
import util.LocalWindowSizeClass
import util.toColor

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
@Preview
fun App() {
    KoinContext {
        PreComposeApp {
            CompositionLocalProvider(
                LocalWindowSizeClass provides calculateWindowSizeClass()
            ) {
                val navigator = rememberNavigator()
                val viewModel = koinViewModel(MainViewModel::class)
                val state by viewModel.state.collectAsState()

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