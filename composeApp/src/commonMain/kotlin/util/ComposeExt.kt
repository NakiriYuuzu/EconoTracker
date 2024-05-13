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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import co.touchlab.kermit.Logger

@Composable
@ReadOnlyComposable
internal fun Dp.toSp() = with(LocalDensity.current) { this@toSp.toSp() }

/**
 * Idea is to take a value of a animation/transition progress, like if progress is going from 0-1,
 * this function will switch the values to map to 1-0 instead.
 */
internal fun Float.inverse() = 1f - this

internal enum class KeyboardState {
    Opened,
    Closed
}

@Composable
internal fun keyboardVisibilityAsState(): State<KeyboardState> {
    return rememberUpdatedState(
        if (WindowInsets.ime.getBottom(LocalDensity.current) > 0) KeyboardState.Opened
        else KeyboardState.Closed
    )
}

internal class Ref(var value: Int)

// Note the inline function below which ensures that this function is essentially
// copied at the call site to ensure that its logging only recompositions from the
// original call site.
@Stable
@Composable
internal fun LogCompositions(tag: String, msg: String) {
    val ref = remember { Ref(0) }
    SideEffect { ref.value++ }
    Logger.d(tag) { "Compositions: $msg ${ref.value}" }
}