package core.data.source

interface EconoDataSource {
    interface Remote {
        suspend fun getEconoData(): String
    }

    interface Local {
        suspend fun getEconoData(): String
    }

    interface Cache {
        suspend fun getEconoData(): String
    }
}