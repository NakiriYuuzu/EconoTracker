package core.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EconoScaffold(
    modifier: Modifier = Modifier,
    topAppBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = topAppBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) { padding ->
        content(padding)
    }
}