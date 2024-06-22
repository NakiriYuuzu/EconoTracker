package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import core.data.source.local.AppDatabase
import core.data.source.local.instantiateImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

internal fun getAppDatabase(): AppDatabase {
    val dbFilePath = NSHomeDirectory() + "/${AppDatabase.DATABASE_NAME}"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
        factory = { AppDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .fallbackToDestructiveMigration(true)
        .build()
}