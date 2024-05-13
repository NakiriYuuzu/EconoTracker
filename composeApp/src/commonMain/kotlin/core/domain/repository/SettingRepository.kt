package core.domain.repository

import core.data.source.preference.ThemeMode
import core.presentation.setting.SettingState
import kotlinx.coroutines.flow.StateFlow

interface SettingRepository {
    val state: StateFlow<SettingState>
    suspend fun getThemeMode(): ThemeMode
    suspend fun getThemeColor(): String
    suspend fun updateThemeMode(theme: ThemeMode)
    suspend fun updateThemeColor(color: String)
}