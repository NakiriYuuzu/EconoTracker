package core.presentation.navigations

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
        createTransition = slideInHorizontally(initialOffsetX = { it }),
        destroyTransition = slideOutHorizontally(targetOffsetX = { it }),
        pauseTransition = fadeOut(targetAlpha = 0.5f),
        resumeTransition = fadeIn(initialAlpha = 0.5f)
    )
}

/**
 * @param spaceToSwipe The space to swipe to trigger the navigation
 * @param positionalThreshold The threshold to trigger the navigation
 * @param velocityThreshold The velocity threshold to trigger the navigation
 */
fun swipeLikeIOS(
    spaceToSwipe: Dp = 100.dp,
    positionalThreshold: (totalDistance: Float) -> Float = { totalDistance -> totalDistance * 0.5f },
    velocityThreshold: Density.() -> Float = { 56.dp.toPx() }
) : SwipeProperties {
    return SwipeProperties(
        spaceToSwipe = spaceToSwipe,
        positionalThreshold = positionalThreshold,
        velocityThreshold =  velocityThreshold
    )
}