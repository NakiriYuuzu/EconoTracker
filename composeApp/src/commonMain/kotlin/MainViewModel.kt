import core.data.source.EconoSource
import core.data.source.preference.ThemeMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class MainViewModel(
    private val preference: EconoSource.Preference
) : ViewModel() {
    private val _useDarkTheme = MutableStateFlow(ThemeMode.SYSTEM)
    val useDarkTheme = _useDarkTheme.asStateFlow()

    init {
        viewModelScope.launch {
            _useDarkTheme.value = preference.getThemeMode()
        }
    }

    fun setDarkTheme(theme: ThemeMode) {
        viewModelScope.launch {
            _useDarkTheme.value = theme
            preference.setDarkMode(theme)
        }
    }
}