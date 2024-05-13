package core.presentation.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import core.data.source.preference.ThemeMode
import core.presentation.components.EconoSelectTextField
import core.presentation.components.EconoScaffold
import core.presentation.components.EconoTextField
import core.presentation.components.EconoTopBar
import econotracker.composeapp.generated.resources.Res
import econotracker.composeapp.generated.resources.menu_setting
import econotracker.composeapp.generated.resources.setting_color_theme_desc
import econotracker.composeapp.generated.resources.setting_color_theme_title
import econotracker.composeapp.generated.resources.setting_style_theme_desc
import econotracker.composeapp.generated.resources.setting_style_theme_title
import econotracker.composeapp.generated.resources.setting_style_title
import moe.tlaster.precompose.koin.koinViewModel
import org.jetbrains.compose.resources.stringResource

@Composable
fun SettingScreenRoot(
    viewModel: SettingViewModel = koinViewModel(SettingViewModel::class),
    onBackClicked: () -> Unit
) {
    SettingScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                SettingAction.OnBackClick -> onBackClicked()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    state: SettingState,
    onAction: (SettingAction) -> Unit
) {
    EconoScaffold(
        topAppBar = {
            EconoTopBar(
                showBackButton = true,
                title = stringResource(Res.string.menu_setting),
                onBackClick = {
                    onAction(SettingAction.OnBackClick)
                }
            )
        }
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(resource = Res.string.setting_style_title),
                    fontWeight = FontWeight.Bold,
                    fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                ) {
                    Column(modifier = Modifier.weight(0.6f)) {
                        Text(
                            text = stringResource(resource = Res.string.setting_style_theme_title),
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = MaterialTheme.typography.bodyMedium.fontStyle)
                        Text(
                            text = stringResource(resource = Res.string.setting_style_theme_desc),
                            fontStyle = MaterialTheme.typography.bodySmall.fontStyle)
                    }
                    EconoSelectTextField(
                        value = state.useDarkTheme.name,
                        options = ThemeMode.entries.map { it.name },
                        onValueChangedEvent = { value ->
                            when (value) {
                                ThemeMode.SYSTEM.name -> onAction(SettingAction.OnThemeModeValueChange(ThemeMode.SYSTEM))
                                ThemeMode.LIGHT.name -> onAction(SettingAction.OnThemeModeValueChange(ThemeMode.LIGHT))
                                ThemeMode.DARK.name -> onAction(SettingAction.OnThemeModeValueChange(ThemeMode.DARK))
                            }
                        },
                        modifier = Modifier.weight(0.4f)
                    )
                }
                HorizontalDivider()
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                ) {
                    Column(modifier = Modifier.weight(0.6f)) {
                        Text(
                            text = stringResource(resource = Res.string.setting_color_theme_title),
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = MaterialTheme.typography.bodyMedium.fontStyle)
                        Text(
                            text = stringResource(resource = Res.string.setting_color_theme_desc),
                            fontStyle = MaterialTheme.typography.bodySmall.fontStyle)
                    }

                    EconoTextField(
                        value = state.useThemeColor,
                        onValueChange = {  },
                        startIcon = null,
                        endIcon = null,
                        hints = "FF00FF",
                        title = null,
                        modifier = Modifier.weight(0.4f)
                    )
                }
                HorizontalDivider()
            }
        }
    }
}