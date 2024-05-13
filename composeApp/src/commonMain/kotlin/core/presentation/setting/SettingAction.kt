package core.presentation.setting

import core.data.source.preference.ThemeMode

sealed interface SettingAction {
    data class OnThemeModeValueChange(val theme: ThemeMode): SettingAction
    data class OnThemeColorValueChange(val color: String): SettingAction
    data object OnBackClick: SettingAction
}