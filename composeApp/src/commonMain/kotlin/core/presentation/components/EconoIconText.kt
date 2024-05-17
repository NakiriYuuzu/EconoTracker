package core.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun EconoIconText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    startIcon: (@Composable () -> Unit)? = null,
    endIcon: (@Composable () -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        startIcon?.let { icon ->
            icon()
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text,
            style = style
        )
        endIcon?.let { icon ->
            Spacer(modifier = Modifier.width(8.dp))
            icon()
        }
    }
}