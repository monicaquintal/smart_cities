package br.com.fiap.meuscontatos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_contato")
data class Contato (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String = "",
    val telefone: String = "",
    @ColumnInfo(name = "is_amigo") val amigo: Boolean = false
)