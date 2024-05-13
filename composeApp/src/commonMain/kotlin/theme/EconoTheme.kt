package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.materialkolor.rememberDynamicColorScheme
import core.data.source.preference.ThemeMode

@Composable
fun EconoTheme(
    seedColor: Color = Color(0xFF63A002),
    useDarkTheme: ThemeMode,
    content: @Composable () -> Unit
) {
    val isDarkTheme = when (useDarkTheme) {
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
    }
    val colorScheme = rememberDynamicColorScheme(seedColor, isDarkTheme)

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = econoShape,
        typography = PoppinsTypography()
    ) { content() }
}