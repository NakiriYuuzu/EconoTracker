package core.presentation.setting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import core.data.source.EconoSource
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class SettingViewModel(
    private val preference: EconoSource.Preference
): ViewModel() {
    var state by mutableStateOf(SettingState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                useDarkTheme = preference.getThemeMode(),
                useThemeColor = preference.getThemeColor()
            )
        }
    }

    fun onAction(action: SettingAction) {
        when (action) {
            is SettingAction.OnThemeColorValueChange -> {
                state = state.copy(

                )
            }
            is SettingAction.OnThemeModeValueChange -> {
                state = state.copy(useDarkTheme = action.theme)
                viewModelScope.launch {
                    preference.setDarkMode(action.theme)
                }
            }
            else -> Unit
        }
    }
}