package br.com.eduardovpessoa.palindromo.data.dao

import androidx.room.*
import br.com.eduardovpessoa.palindromo.data.entity.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Delete
    suspend fun delete(word: Word)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: Word)

    @Query("SELECT * FROM words ORDER BY id DESC")
    suspend fun queryAll(): Flow<MutableList<Word>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(word: Word)

}