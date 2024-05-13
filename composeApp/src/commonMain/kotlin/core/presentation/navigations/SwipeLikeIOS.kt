package core.presentation.navigations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.SwipeProperties
import moe.tlaster.precompose.navigation.transition.NavTransition

fun swipeAnimationIOS(): NavTransition {
    return NavTransition(
        createTransition = slideInHorizontally(tween(easing = LinearEasing)) { it },
        destroyTransition = slideOutHorizontally(tween(easing = LinearEasing)) { it },
        pauseTransition = slideOutHorizontally(tween(easing = LinearEasing)) { -it / 5 },
        resumeTransition = slideInHorizontally(tween(easing = LinearEasing)) { -it / 5 },
        exitTargetContentZIndex = 1f
    )
}