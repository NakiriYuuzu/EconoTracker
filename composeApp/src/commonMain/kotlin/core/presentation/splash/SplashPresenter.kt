package core.presentation.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import logging.Logger

@Composable
fun SplashPresenter(
    logger: Logger
) : SplashState {
    var count by remember { mutableIntStateOf(0) }

    return SplashState(
        count = count
    ) {
        when (it) {
            is SplashAction.UpdateCount -> { count++; logger.e("Presenter Count: ") {count.toString()} }
        }
    }
}