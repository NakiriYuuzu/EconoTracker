package core.data.source.preference

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.toSuspendSettings
import core.data.source.EconoSource
import theme.COLOR
import util.toStringColor

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
        suspendSettings.getString(THEME_COLOR_THEME_KEY, COLOR.toStringColor()).let {
            return it
        }
    }

    override suspend fun setThemeColor(color: String) {
        suspendSettings.putString(THEME_COLOR_THEME_KEY, color)
    }

    companion object {
        private const val DARK_MODE_KEY = "DARK_MODE_KEY"
        private const val THEME_COLOR_THEME_KEY = "THEME_COLOR_THEME_KEY"
    }
}