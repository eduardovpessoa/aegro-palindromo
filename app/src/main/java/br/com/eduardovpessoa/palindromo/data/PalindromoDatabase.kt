package br.com.eduardovpessoa.palindromo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.eduardovpessoa.palindromo.data.converter.DateConverter
import br.com.eduardovpessoa.palindromo.data.dao.WordDao
import br.com.eduardovpessoa.palindromo.data.entity.Word

@Database(
    entities = [Word::class],
    version = 1
)
@TypeConverters(
    DateConverter::class
)
abstract class PalindromoDatabase : RoomDatabase() {

    abstract fun wordDao() : WordDao

    companion object {
        @Volatile
        private var INSTANCE: PalindromoDatabase? = null

        fun getDatabase(context: Context): PalindromoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PalindromoDatabase::class.java,
                    "palindromo_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}