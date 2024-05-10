package core.presentation.splash

sealed interface SplashAction {
    data object UpdateCount : SplashAction
}