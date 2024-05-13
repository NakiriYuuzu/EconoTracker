package util

fun Long.toStringColor() : String {
    val colorString = this.toString(16).uppercase()
    return if (colorString.length > 6) {
        colorString.substring(2, 8)
    } else {
        colorString
    }
}

fun String.toLongColorString() : Long {
    return "ff$this".toLong(16)
}