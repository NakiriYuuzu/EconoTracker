package core.presentation.setting

import core.presentation.components.utils.UiText

sealed interface SettingEvent {
    data object ThemeModeUpdated: SettingEvent
    data object ThemeColorUpdated: SettingEvent
    data class Error(val message: UiText): SettingEvent
}