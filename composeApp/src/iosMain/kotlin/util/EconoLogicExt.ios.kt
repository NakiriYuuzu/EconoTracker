package util

import androidx.compose.ui.util.fastMap
import platform.Foundation.ISOCountryCodes
import platform.Foundation.NSLocale
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterCurrencyStyle
import platform.Foundation.localeWithLocaleIdentifier

actual fun Double.formatCurrency(countryCode: String): String {
    val formatter = NSNumberFormatter().apply {
        numberStyle = NSNumberFormatterCurrencyStyle
        locale = NSLocale.localeWithLocaleIdentifier(countryCode)
    }
    val number = NSNumber(this)
    return formatter.stringFromNumber(number) ?: "$0.00"
}

actual fun getCountryCode(): List<String> {
    return NSLocale.ISOCountryCodes.fastMap { code -> code.toString() }
}