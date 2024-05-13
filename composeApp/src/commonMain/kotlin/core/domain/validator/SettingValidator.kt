package core.domain.validator

class SettingValidator {
    fun isColorLengthValid(color: String): Boolean {
        return color.length == 3 || color.length == 6
    }
    fun isColorValid(color: String): Boolean {
        if (color.isEmpty()) return false
        return color.matches(Regex("^([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$"))
    }
}