
import core.data.source.EconoSource
import core.presentation.setting.SettingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class MainViewModel(
    private val preference: EconoSource.Preference
) : ViewModel() {
    private val _state = MutableStateFlow(SettingState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = state.value.copy(
                useDarkTheme = preference.getThemeMode(),
                useThemeColor = preference.getThemeColor()
            )
        }
    }
}