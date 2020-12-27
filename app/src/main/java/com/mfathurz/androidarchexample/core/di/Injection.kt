package com.mfathurz.androidarchexample.core.di

import com.mfathurz.androidarchexample.core.data.Repository
import com.mfathurz.androidarchexample.core.ui.ViewModelFactory

object Injection {

    private fun provideRepository(): Repository = Repository.getInstance()

    fun provideViewModelFactory(): ViewModelFactory =
        ViewModelFactory.getInstance(provideRepository())
}