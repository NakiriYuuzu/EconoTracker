@file:OptIn(ExperimentalComposeUiApi::class)

package util

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
actual fun getScreenWidthDp(): Dp = LocalWindowInfo.current.containerSize.width.dp

@Composable
actual fun getScreenHeightDp(): Dp = LocalWindowInfo.current.containerSize.height.dp