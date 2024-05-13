package core.presentation.setting

import core.data.source.preference.ThemeMode
import core.presentation.setting.validator.SettingValidatorState
import theme.COLOR
import util.toStringColor

data class SettingState(
    val themeMode: ThemeMode = ThemeMode.SYSTEM,
    val themeColor: String = COLOR.toStringColor(),
    val themeValidatorState: SettingValidatorState = SettingValidatorState(),
    val canChangeThemeColor: Boolean = false
)