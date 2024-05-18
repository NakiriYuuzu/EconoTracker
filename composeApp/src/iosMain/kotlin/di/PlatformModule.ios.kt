package di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import core.data.source.local.ExpenseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSHomeDirectory

actual fun platformModule(): Module = module {
    single<ExpenseDatabase> { getDatabase() }
}

internal fun getDatabase(): ExpenseDatabase {
    val dbFilePath = NSHomeDirectory() + "/expenses.db"
    return Room.databaseBuilder<ExpenseDatabase>(
        name = dbFilePath,
        factory = { ExpenseDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}