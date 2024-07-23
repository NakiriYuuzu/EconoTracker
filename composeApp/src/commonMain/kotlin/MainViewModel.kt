import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.repository.SettingRepository
import kotlinx.coroutines.launch

class MainViewModel(
    settingRepository: SettingRepository
) : ViewModel() {
    val state = settingRepository.state

    init {
        viewModelScope.launch {
            settingRepository.getThemeMode()
            settingRepository.getThemeColor()
        }
    }
}