package core.presentation.setting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import core.domain.repository.SettingRepository
import core.presentation.setting.validator.SettingValidator
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class SettingViewModel(
    private val settingRepository: SettingRepository,
    private val settingValidator: SettingValidator
): ViewModel() {
    private val settingState = settingRepository.state

    var state by mutableStateOf(SettingState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                themeMode = settingState.value.themeMode,
                themeColor = settingState.value.themeColor,
                themeValidatorState = settingValidator.validateColor(settingState.value.themeColor)
            )
        }
    }

    fun onAction(action: SettingAction) {
        when (action) {
            is SettingAction.OnThemeColorValueChange -> {
                val colorValidation = settingValidator.validateColor(action.color)
                if (action.color.length <= 6) state = state.copy(
                    themeColor = action.color,
                    themeValidatorState = colorValidation,
                    canChangeThemeColor = colorValidation.isValidColor
                )
                if (state.canChangeThemeColor) {
                    viewModelScope.launch {
                        settingRepository.updateThemeColor(action.color)
                    }
                }
            }
            is SettingAction.OnThemeModeValueChange -> {
                state = state.copy(themeMode = action.theme)
                viewModelScope.launch {
                    settingRepository.updateThemeMode(action.theme)
                }
            }
            else -> Unit
        }
    }
}