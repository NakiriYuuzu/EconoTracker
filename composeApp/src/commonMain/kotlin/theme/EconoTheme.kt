package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.materialkolor.rememberDynamicColorScheme

@Composable
fun EconoTheme(
    seedColor: Color = Color(0xFF63A002),
    useSurface: Boolean = false,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = rememberDynamicColorScheme(seedColor, useDarkTheme)


    MaterialTheme(
        colorScheme = colorScheme,
        typography = PoppinsTypography()
    ) {
        if (useSurface) {
            Surface(modifier = Modifier.fillMaxSize()) {
                content()
            }
        } else {
            content()
        }
    }
}