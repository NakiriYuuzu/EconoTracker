import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import navigation.EconoGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import theme.EconoTheme
import util.LocalSettingState
import util.LocalWindowSizeClass
import util.koinViewModel
import util.toColor

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
@Preview
fun App() {
    KoinContext {
        val viewModel = koinViewModel<MainViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()

        CompositionLocalProvider(
            LocalWindowSizeClass provides calculateWindowSizeClass(),
            LocalSettingState provides state
        ) {
            EconoTheme(
                seedColor = state.themeColor.toColor(),
                themeMode = state.themeMode
            ) {
                EconoGraph()
            }
        }
    }
}