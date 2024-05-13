package util

import androidx.compose.ui.graphics.Color

fun Long.toColor() : Color {
    this.toString(16)
    return Color(this.toInt())
}

fun Long.toStringColor() : String {
    val colorString = this.toString(16)
    return if (colorString.length > 6) {
        colorString.substring(2, 8)
    } else {
        colorString
    }
}

fun String.toLongColor() : Long {
    return "ff$this".toLong(16)
}