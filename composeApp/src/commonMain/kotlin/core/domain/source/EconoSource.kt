package core.domain.source

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
        suspend fun setThemeMode(theme: ThemeMode)
        suspend fun getThemeColor(): Long
        suspend fun setThemeColor(color: String)
    }
}