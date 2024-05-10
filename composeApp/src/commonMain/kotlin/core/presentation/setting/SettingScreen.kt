package core.presentation.setting

import MainViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.data.source.preference.ThemeMode
import core.presentation.components.EconoScaffold
import core.presentation.components.EconoTopBar
import econotracker.composeapp.generated.resources.Res
import econotracker.composeapp.generated.resources.menu_setting
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    viewModel: MainViewModel,
    onBackClicked: () -> Unit
) {
    EconoScaffold(
        topAppBar = {
            EconoTopBar(
                showBackButton = true,
                title = stringResource(Res.string.menu_setting),
                onBackClick = {
                    onBackClicked()
                }
            )
        }
    ) { padding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            var expanded by remember { mutableStateOf(false) }

            Button(onClick = { expanded = true }) {
                Text(text = "CHANGE THEME")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = ThemeMode.SYSTEM.name) },
                    onClick = {
                        viewModel.setDarkTheme(ThemeMode.SYSTEM)
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = ThemeMode.LIGHT.name) },
                    onClick = {
                        viewModel.setDarkTheme(ThemeMode.LIGHT)
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = ThemeMode.DARK.name) },
                    onClick = {
                        viewModel.setDarkTheme(ThemeMode.DARK)
                    }
                )
            }
        }
    }
}