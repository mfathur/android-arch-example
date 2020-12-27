package com.mfathurz.androidarchexample.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mfathurz.androidarchexample.core.data.Repository
import com.mfathurz.androidarchexample.main.MainViewModel

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(repository: Repository): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(repository)
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }

            //kalau ada viewmodel lain bisa ditambahkan di sini
            else -> throw IllegalArgumentException("Unknown viewmodel class ${modelClass.name}")
        }
    }
}