package core.domain.validator

data class SettingValidatorState(
    val isColorLengthValid: Boolean = true,
    val isColorValid: Boolean = true
) {
    val isValidColor: Boolean
        get() = isColorLengthValid && isColorValid
}
