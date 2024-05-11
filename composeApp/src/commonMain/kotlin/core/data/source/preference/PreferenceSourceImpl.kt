package core.data.source.preference

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.toSuspendSettings
import core.data.source.EconoSource

@OptIn(ExperimentalSettingsApi::class)
class PreferenceSourceImpl(settings: Settings): EconoSource.Preference {

    private val suspendSettings = settings.toSuspendSettings()

    override suspend fun getThemeMode(): ThemeMode {
        suspendSettings.getString(DARK_MODE_KEY, ThemeMode.SYSTEM.name).let {
            return ThemeMode.valueOf(it)
        }
    }

    override suspend fun setDarkMode(theme: ThemeMode) {
        suspendSettings.putString(DARK_MODE_KEY, theme.name)
    }

    override suspend fun getThemeColor(): String {
        TODO("Not yet implemented")
    }

    override suspend fun setThemeColor(color: String) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DARK_MODE_KEY = "DARK_MODE_KEY"
//        private const val THEME_COLOR_THEME_KEY = "THEME_COLOR_THEME_KEY"
    }
}