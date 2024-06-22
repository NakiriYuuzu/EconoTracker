package core.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import core.domain.model.Category
import core.domain.model.Expense

@Database(
    entities = [Expense::class, Category::class],
    version = 2
)
abstract class AppDatabase: RoomDatabase(), DB {
    abstract fun expenseDao(): ExpenseDao

    abstract fun categoryDao(): CategoryDao

    override fun clearAllTables() {
        super.clearAllTables()
    }

    companion object {
        const val DATABASE_NAME = "yuuzu.db"
    }
}