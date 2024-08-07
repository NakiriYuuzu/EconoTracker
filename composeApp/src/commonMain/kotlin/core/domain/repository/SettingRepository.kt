package core.domain.repository

import core.data.source.preference.ThemeMode
import core.domain.util.DataError
import core.domain.util.EmptyResult
import core.presentation.setting.SettingState
import kotlinx.coroutines.flow.StateFlow

interface SettingRepository {
    val state: StateFlow<SettingState>
    suspend fun getThemeMode(): ThemeMode
    suspend fun getThemeColor(): String
    suspend fun setThemeMode(theme: ThemeMode)
    suspend fun setThemeColor(color: String)
}