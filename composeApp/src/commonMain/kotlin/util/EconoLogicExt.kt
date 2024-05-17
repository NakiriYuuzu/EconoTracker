package util

/**
 * Get the list of country codes from the platform specific implementation
 * @return List of country codes
 */
expect fun getCountryCode(): List<String>

/**
 * Format the currency based on the country code
 * @param countryCode The country code to format the currency
 * @return The formatted currency
 */
expect fun Double.formatCurrency(countryCode: String): String