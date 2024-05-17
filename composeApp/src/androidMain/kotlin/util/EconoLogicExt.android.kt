package util

import java.text.NumberFormat
import java.util.Locale

actual fun getCountryCode(): List<String> {
    return Locale.getISOCountries().toList()
}

actual fun Double.formatCurrency(countryCode: String): String {
    val currencyFormat = NumberFormat.getCurrencyInstance(Locale(countryCode))
    return currencyFormat.format(this)
}