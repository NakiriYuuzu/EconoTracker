package core.presentation.splash

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import logging.Logger
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class SplashViewModel(
    private val logger: Logger
) : ViewModel() {
    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    init {
        startTimer()
    }

    private fun startTimer() {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _state.value++
                logger.e("ViewModelCount: ") { state.value.toString() }
            }
        }
    }
}
