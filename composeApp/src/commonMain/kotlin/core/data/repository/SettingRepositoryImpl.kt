package core.data.repository

import core.data.source.preference.ThemeMode
import core.domain.repository.SettingRepository
import core.domain.source.EconoSource
import core.presentation.setting.SettingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import util.toStringColor

class SettingRepositoryImpl(
    private val preference: EconoSource.Preference
): SettingRepository {
    private val _state = MutableStateFlow(SettingState())
    override val state: StateFlow<SettingState>
        get() = _state.asStateFlow()

    override suspend fun getThemeMode(): ThemeMode {
        println("SettingRepository: ${preference.getThemeMode()}")
        _state.value = _state.value.copy(themeMode = preference.getThemeMode())
        return preference.getThemeMode()
    }

    override suspend fun getThemeColor(): String {
        println("SettingRepository: ${preference.getThemeColor()}")
        _state.value = _state.value.copy(themeColor = preference.getThemeColor().toStringColor())
        return preference.getThemeColor().toStringColor()
    }

    override suspend fun updateThemeMode(theme: ThemeMode) {
        println("SettingRepositoryUpdate: $theme")
        _state.value = _state.value.copy(themeMode = theme)
        preference.setThemeMode(theme)
    }

    override suspend fun updateThemeColor(color: String) {
        println("SettingRepositoryUpdate: $color")
        _state.value = _state.value.copy(themeColor = color)
        preference.setThemeColor(color)
    }
}