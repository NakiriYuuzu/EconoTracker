package core.presentation.splash

data class SplashState(
    val count: Int = 0,
    val onAction: (SplashAction) -> Unit
)