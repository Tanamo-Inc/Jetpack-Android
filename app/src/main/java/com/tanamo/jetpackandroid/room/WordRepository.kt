package com.tanamo.jetpackandroid.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

/***
 *A Repository class abstracts access to multiple data sources.
 *The Repository is not part of the Architecture Components libraries,
 *but is a suggested best practice for code separation and architecture.
 *A Repository class provides a clean API for data access to the rest of the application.
 *A Repository manages queries and allows you to use multiple backends
 ***/

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}