package core.data.source.preference

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.toSuspendSettings
import core.domain.source.EconoSource
import theme.COLOR
import util.toLongColorString

@OptIn(ExperimentalSettingsApi::class)
class PreferenceSourceImpl(settings: Settings): EconoSource.Preference {

    private val suspendSettings = settings.toSuspendSettings()

    override suspend fun getThemeMode(): ThemeMode {
        suspendSettings.getString(DARK_MODE_KEY, ThemeMode.SYSTEM.name).let {
            return ThemeMode.valueOf(it)
        }
    }

    override suspend fun setThemeMode(theme: ThemeMode) {
        suspendSettings.putString(DARK_MODE_KEY, theme.name)
    }

    override suspend fun getThemeColor(): Long {
        suspendSettings.getLong(THEME_COLOR_THEME_KEY, COLOR).let {
            return it
        }
    }

    override suspend fun setThemeColor(color: String) {
        suspendSettings.putLong(THEME_COLOR_THEME_KEY, color.toLongColorString())
    }

    companion object {
        private const val DARK_MODE_KEY = "DARK_MODE_KEY"
        private const val THEME_COLOR_THEME_KEY = "THEME_COLOR_THEME_KEY"
    }
}