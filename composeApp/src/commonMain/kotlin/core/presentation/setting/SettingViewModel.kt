package core.presentation.setting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.data.source.preference.ThemeMode
import core.domain.repository.SettingRepository
import core.domain.validator.SettingValidator
import kotlinx.coroutines.launch

class SettingViewModel(
    private val validator: SettingValidator,
    private val repository: SettingRepository
): ViewModel() {
    var state by mutableStateOf(SettingState())
        private set

    init {
        viewModelScope.launch {
            val colorValidate = validator.validateColor(repository.getThemeColor())
            state = state.copy(
                themeMode = repository.getThemeMode(),
                themeColor = repository.getThemeColor(),
                isValidColor = colorValidate.isValidColor
            )
        }
    }

    fun onAction(action: SettingAction) {
        when (action) {
            is SettingAction.OnThemeColorValueChange -> changeThemeColor(action.color)
            is SettingAction.OnThemeModeValueChange -> changeThemeMode(action.theme)
            else -> Unit
        }
    }

    private fun changeThemeColor(color: String) {
        val colorValidate = validator.validateColor(color)

        if (color.length <= 6) state = state.copy(
            themeColor = color,
            isValidColor = colorValidate.isValidColor,
            settingValidatorState = colorValidate
        )

        if (state.isValidColor) {
            viewModelScope.launch { repository.setThemeColor(color) }
        }
    }

    private fun changeThemeMode(theme: ThemeMode) {
        state = state.copy(themeMode = theme)
        viewModelScope.launch { repository.setThemeMode(theme) }
    }
}