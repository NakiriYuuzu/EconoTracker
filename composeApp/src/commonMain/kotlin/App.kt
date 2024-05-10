import androidx.compose.runtime.*
import core.presentation.navigations.Navigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinContext
import theme.EconoTheme

@Composable
@Preview
fun App() {
    KoinContext {
        PreComposeApp {
            val navigator = rememberNavigator()
            val viewModel = koinViewModel(MainViewModel::class)
            val state by viewModel.useDarkTheme.collectAsStateWithLifecycle()

            EconoTheme(useDarkTheme = state) {
                Navigation(
                    navigator = navigator,
                    viewModel = viewModel
                )
            }
        }
    }
}