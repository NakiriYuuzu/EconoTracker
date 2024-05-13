
import core.domain.repository.SettingRepository
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

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