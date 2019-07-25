package com.tanamo.jetpackandroid.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *The ViewModel's role is to provide data to the UI and survive configuration changes.
 *A ViewModel acts as a communication center between the Repository and the UI.
 *You can also use a ViewModel to share data between fragments.
 *The ViewModel is part of the lifecycle library.
 * A ViewModel holds your app's UI data in a lifecycle-conscious way that survives configuration
 * changes. Separating your app's UI data from your Activity and Fragment classes lets you better
 * follow the single responsibility principle: Your activities and fragments are responsible for
 * drawing data to the screen, while your ViewModel can take care of holding and processing all the
 * data needed for the UI.
 * /**
 * View Model to keep a reference to the word repository and
 * an up-to-date list of all words.
*/
 *
 ***/
class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application,viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }
}