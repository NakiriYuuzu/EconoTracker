package core.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Expense::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase(), DB {
    abstract fun expenseDao(): ExpenseDao
    override fun clearAllTables() {
        super.clearAllTables()
    }

    companion object {
        const val DATABASE_NAME = "yuuzu.db"
    }
}