package core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import core.data.source.preference.ThemeMode
import util.LocalSettingState
import util.getScreenHeightDp
import util.getScreenWidthDp

@Composable
fun EconoBackground(
    hasToolbar: Boolean = true,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val localState = LocalSettingState.current
    val density = LocalDensity.current

    val screenWidthPx = with(density) {
        getScreenWidthDp().roundToPx()
    }
    val smallDimension = minOf(
        getScreenWidthDp(),
        getScreenHeightDp()
    )
    val smallDimensionPx = with(density) {
        smallDimension.roundToPx()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                            MaterialTheme.colorScheme.background
                        ),
                        center = Offset(
                            x = screenWidthPx / 2f,
                            y = -50f
                        ),
                        radius = smallDimensionPx / 1f
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(if (hasToolbar) Modifier else Modifier.systemBarsPadding())
        ) {
            content()
        }
    }
}