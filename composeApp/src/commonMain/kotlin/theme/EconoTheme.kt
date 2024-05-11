package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        typography = PoppinsTypography()
    ) { content() }
}