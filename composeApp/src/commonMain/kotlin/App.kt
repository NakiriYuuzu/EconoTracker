import androidx.compose.runtime.*
import core.presentation.navigators.Navigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinContext
import themes.EconoTheme

@Composable
@Preview
fun App() {
    PreComposeApp {
        KoinContext {
            val navigator = rememberNavigator()
            EconoTheme(useSurface = true) {
                Navigation(navigator = navigator)
            }
        }
    }
}