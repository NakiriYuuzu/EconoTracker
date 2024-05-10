package core.data.source

import core.data.source.preference.ThemeMode

interface EconoSource {
    interface Remote {
        suspend fun getEconoData(): String
    }

    interface Local {
        suspend fun getEconoData(): String
    }

    interface Preference {
        suspend fun getThemeMode(): ThemeMode
        suspend fun setDarkMode(theme: ThemeMode)
    }
}