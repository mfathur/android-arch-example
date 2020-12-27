package com.mfathurz.androidarchexample.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.androidarchexample.core.data.Repository
import com.mfathurz.androidarchexample.core.data.source.model.UserResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _posts = MutableLiveData<List<UserResponse>>()

    val posts: LiveData<List<UserResponse>>
        get() = _posts

    init {
        getPostsFromRepo()
    }

    private fun getPostsFromRepo() = viewModelScope.launch {
        _posts.value = repository.getAllPosts()
    }

}