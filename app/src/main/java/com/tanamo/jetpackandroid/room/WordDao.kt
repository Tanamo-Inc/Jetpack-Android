package com.tanamo.jetpackandroid.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/***
 * A DAO (data access object) validates your SQL at compile-time and associate it with a method,
 *so you don't have to worry about the SQL again... all with simple annotations like @Insert!
 *The DAO must be an interface or abstract class.
 *By default, all queries must be executed on a separate thread.
 *Room has coroutines support. So your queries can be annotated with the suspend modifier
 *and called from a coroutine or from another suspension function.
 * Room uses the DAO to create a clean API for your code.
 * Use a return value of type LiveData in your method description, and Room generates
 * all necessary code to update the LiveData when the database is updated.
 ***/

@Dao
interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Insert
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}