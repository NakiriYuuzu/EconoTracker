package core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import util.KeyboardState
import util.keyboardVisibilityAsState

@Composable
fun EconoTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hints: String,
    title: String?,
    startIcon: ImageVector?,
    endIcon: ImageVector?,
    error: String? = null,
    modifier: Modifier = Modifier,
    imeAction: ImeAction = ImeAction.Done,
    keyboardType: KeyboardType = KeyboardType.Text,
    additionalInfo: String? = null,
    onDone: () -> Unit = {},
) {
    val focusManager = LocalFocusManager.current
    val keyboardState by keyboardVisibilityAsState()
    var isFocused by remember { mutableStateOf(false) }

    LaunchedEffect(keyboardState) {
        if (keyboardState == KeyboardState.Closed) focusManager.clearFocus()
    }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (title != null) {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (error != null) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp
                )
            } else if (additionalInfo != null) {
                Text(
                    text = additionalInfo,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 12.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                onDone = {
                    focusManager.clearFocus()
                    if (imeAction == ImeAction.Done) onDone()
                }
            ),
            singleLine = true,
            decorationBox = { innerBox ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (startIcon != null) {
                        Icon(
                            imageVector = startIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        if (value.isEmpty() && !isFocused) {
                            Text(
                                text = hints,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                                    alpha = 0.4f
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        innerBox()
                    }
                    if (endIcon != null) {
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            imageVector = endIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            },
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .background(
                    if (isFocused) {
                        MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.05f
                        )
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                )
                .border(
                    width = 1.dp,
                    color = if (isFocused) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                    },
                    shape = MaterialTheme.shapes.small
                )
                .padding(12.dp)
                .onFocusChanged { isFocused = it.isFocused }

        )
//        BasicTextField2(
//            state = state,
//            textStyle = LocalTextStyle.current.copy(
//                color = MaterialTheme.colorScheme.onBackground
//            ),
//            inputTransformation = inputTransformation,
//            keyboardOptions = KeyboardOptions(
//                keyboardType = keyboardType,
//                imeAction = imeAction
//            ),
//            keyboardActions = KeyboardActions(
//                onNext = {
//                    focusManager.moveFocus(FocusDirection.Next)
//                },
//                onDone = {
//                    focusManager.clearFocus()
//                    if (imeAction == ImeAction.Done) onDone()
//                }
//            ),
//            lineLimits = TextFieldLineLimits.SingleLine,
//            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
//            modifier = Modifier
//                .clip(RoundedCornerShape(8.dp))
//                .background(
//                    if (isFocused) {
//                        MaterialTheme.colorScheme.primary.copy(
//                            alpha = 0.1f
//                        )
//                    } else {
//                        MaterialTheme.colorScheme.surface
//                    }
//                )
//                .border(
//                    width = 1.dp,
//                    color = if (isFocused) {
//                        MaterialTheme.colorScheme.primary
//                    } else {
//                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
//                    },
//                    shape = RoundedCornerShape(8.dp)
//                )
//                .padding(12.dp)
//                .onFocusChanged { isFocused = it.isFocused },
//            decorator = { innerBox ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    if (startIcon != null) {
//                        Icon(
//                            imageVector = startIcon,
//                            contentDescription = null,
//                            tint = MaterialTheme.colorScheme.onSurfaceVariant
//                        )
//                        Spacer(modifier = Modifier.width(16.dp))
//                    }
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                    ) {
//                        if (state.text.isEmpty() && !isFocused) {
//                            Text(
//                                text = hints,
//                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
//                                    alpha = 0.4f
//                                ),
//                                modifier = Modifier.fillMaxWidth()
//                            )
//                        }
//                        innerBox()
//                    }
//                    if (endIcon != null) {
//                        Spacer(modifier = Modifier.width(16.dp))
//                        Icon(
//                            imageVector = endIcon,
//                            contentDescription = null,
//                            tint = MaterialTheme.colorScheme.onSurfaceVariant
//                        )
//                    }
//                }
//            }
//        )
    }
}