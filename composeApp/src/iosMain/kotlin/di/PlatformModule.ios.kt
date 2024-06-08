package di

import core.data.source.local.AppDatabase
import database.getAppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<AppDatabase> { getAppDatabase() }
}

