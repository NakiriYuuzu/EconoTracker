package core.presentation.navigations

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import moe.tlaster.precompose.navigation.transition.NavTransition

fun navIosTransition(): NavTransition {
    return NavTransition(
        createTransition = slideInHorizontally(tween(easing = FastOutSlowInEasing)) { it },
        destroyTransition = slideOutHorizontally(tween(easing = FastOutSlowInEasing)) { it },
        pauseTransition = slideOutHorizontally(tween(easing = FastOutSlowInEasing)) { -it / 2 },
        resumeTransition = slideInHorizontally(tween(easing = FastOutSlowInEasing)) { -it / 2 },
        exitTargetContentZIndex = 1f
    )
}