package core.presentation.expense.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowCircleDown
import androidx.compose.material.icons.twotone.ArrowCircleUp
import androidx.compose.material.icons.twotone.ArrowDropDown
import androidx.compose.material.icons.twotone.MoreHoriz
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import core.presentation.components.EconoIconText
import core.presentation.components.EconoScaffold
import core.presentation.components.EconoTopBar
import core.presentation.components.utils.DropDownItem
import econotracker.composeapp.generated.resources.Res
import econotracker.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource
import theme.COLOR

@Composable
fun HomeScreenRoot(
    onSettingClick: (DropDownItem) -> Unit
) {
    HomeScreen(
        onSettingClick = onSettingClick
    )
}

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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            EconoBalanceCard(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
        }
    }
}

@Composable
fun EconoBalanceCard(
    modifier: Modifier = Modifier,
    totalBalance: String = "$1000.00",
    income: String = "$1,000,000,000.00",
    expense: String = "$1,000,000,000.00",
    isAmountPositive: Boolean = false,
) {
    ElevatedCard(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    EconoIconText(
                        text = "Total Balance",
                        style = MaterialTheme.typography.titleSmall,
                        endIcon = {
                            Icon(
                                imageVector = Icons.TwoTone.ArrowDropDown,
                                contentDescription = null,
                                tint = if (isAmountPositive) Color(COLOR) else MaterialTheme.colorScheme.error,
                                modifier = Modifier.rotate(if (isAmountPositive) 180f else 0f)
                            )
                        },
                    )
                }
                Text(
                    text = totalBalance,
                    style = MaterialTheme.typography.headlineMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.TwoTone.MoreHoriz, contentDescription = null)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                EconoIconText(
                    text = "Income",
                    style = MaterialTheme.typography.titleSmall,
                    startIcon = {
                        Icon(
                            imageVector = Icons.TwoTone.ArrowCircleUp,
                            contentDescription = null,
                            tint = Color(COLOR)
                        )
                    },
                    modifier = Modifier.align(Alignment.Start)
                )
                Text(
                    text = income,
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                EconoIconText(
                    text = "Expense",
                    style = MaterialTheme.typography.titleSmall,
                    endIcon = {
                        Icon(
                            imageVector = Icons.TwoTone.ArrowCircleDown,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error
                        )
                    },
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = expense,
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}