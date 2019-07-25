package com.tanamo.jetpackandroid.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * Entity represents data for a single table row, constructed using an annotated java data object.
 *Each entity is persisted into its own table .
 *Each @Entity class represents a table. Annotate your class declaration to indicate that it's an entity.
 *Specify the name of the table if you want it to be different from the name of the class.
 *Every entity needs a primary key. To keep things simple, each word acts as its own primary key.
 */


@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)

