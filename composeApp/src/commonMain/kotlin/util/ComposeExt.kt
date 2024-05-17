package util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import co.touchlab.kermit.Logger
import core.presentation.setting.SettingState

internal val LocalSettingState =
    staticCompositionLocalOf<SettingState> { error("No StateHolder found") }

@Composable
@ReadOnlyComposable
internal fun Dp.toSp() = with(LocalDensity.current) { this@toSp.toSp() }

/**
 * Keep track of the keyboard state
 */
internal enum class KeyboardState {
    Opened,
    Closed
}

/**
 * Keyboard state as a composable
 * @return [State] of [KeyboardState]
 */
@Composable
internal fun keyboardVisibilityAsState(): State<KeyboardState> {
    return rememberUpdatedState(
        if (WindowInsets.ime.getBottom(LocalDensity.current) > 0) KeyboardState.Opened
        else KeyboardState.Closed
    )
}