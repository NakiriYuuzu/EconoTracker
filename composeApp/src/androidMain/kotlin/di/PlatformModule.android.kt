package di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import core.data.source.local.ExpenseDatabase
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<ExpenseDatabase> { getDatabase(get()) }
}

internal fun getDatabase(context: Context): ExpenseDatabase {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("expenses.db")
    return Room.databaseBuilder<ExpenseDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}