package core.presentation.components.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource

sealed interface UiText {
    data class DynamicString(val value: String) : UiText
    class StringResource(
        val res: org.jetbrains.compose.resources.StringResource,
        val args: Array<Any> = arrayOf()
    ) : UiText

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(res, *args)
        }
    }

    suspend fun collectAsString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> getString(res, *args)
        }
    }
}