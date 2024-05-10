package net.yuuzu.preview

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import core.presentation.components.EconoTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun PreviewSample() {
    EconoTopBar(showBackButton = true, title = "Hello World.")
}