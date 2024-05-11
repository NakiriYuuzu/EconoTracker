package core.presentation.expense.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.presentation.components.EconoScaffold
import core.presentation.components.EconoTopBar
import core.presentation.components.utils.DropDownItem
import econotracker.composeapp.generated.resources.Res
import econotracker.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onSettingClick: (DropDownItem) -> Unit,
) {
    EconoScaffold(
        topAppBar = {
            EconoTopBar(
                showBackButton = false,
                title = stringResource(Res.string.app_name),
                menuItems = DropDownItem.settingsList,
                onMenuItemClick = { index ->
                    when (index) {
                        0 -> onSettingClick(DropDownItem.settingsList[index])
                    }
                }
            )
        }) { padding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

        }
    }
}