import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import core.presentation.components.EconoScaffold
import core.presentation.components.EconoTopBar

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AddOrEditScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddOrEditScreen() {
    EconoScaffold(
        topAppBar = {
            EconoTopBar(
                showBackButton = true,
                title = "Add Expense"
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            
        }
    }
}