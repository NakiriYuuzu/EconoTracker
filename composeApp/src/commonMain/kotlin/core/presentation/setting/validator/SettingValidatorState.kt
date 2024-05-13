package core.presentation.setting.validator

data class SettingValidatorState(
    val isColorLengthValid: Boolean = false,
    val isColorValid: Boolean = false
) {
    val isValidColor: Boolean
        get() = isColorLengthValid && isColorValid

    val currentError: String?
        get() = when {
            !isColorLengthValid -> "length must be 6 digit."
            !isColorValid -> "must be a valid hex color"
            else -> null
        }
}
