package br.com.eduardovpessoa.palindromo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "is_palindromo") val isPalindromo: Boolean? = false,
    @ColumnInfo(name = "registred") val registred: Date? = Date()
)