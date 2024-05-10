package core.presentation.components.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import econotracker.composeapp.generated.resources.Res
import econotracker.composeapp.generated.resources.menu_setting
import org.jetbrains.compose.resources.stringResource

data class DropDownItem(
    val icon: ImageVector,
    val title: (@Composable () -> Unit),
    val active: Boolean = false,
) {
    companion object {
        val settingsList = listOf(
            DropDownItem(
                icon = Icons.Outlined.Settings,
                title = {
                    Text(
                        text = stringResource(Res.string.menu_setting),
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                active = true
            )
        )
    }
}