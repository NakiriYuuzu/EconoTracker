package core.presentation.setting

import core.data.source.preference.ThemeMode

data class SettingState(
    val useDarkTheme: ThemeMode = ThemeMode.SYSTEM,
    val useThemeColor: String = "63A002"
)