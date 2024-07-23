package core.presentation.setting

import core.data.source.preference.ThemeMode
import core.domain.validator.SettingValidatorState
import theme.COLOR
import util.toStringColor

data class SettingState(
    val themeMode: ThemeMode = ThemeMode.SYSTEM,
    val themeColor: String = COLOR.toStringColor(),
    val isValidColor: Boolean = false,
    val settingValidatorState: SettingValidatorState = SettingValidatorState()
)