package com.mfathurz.androidarchexample.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mfathurz.androidarchexample.core.data.Repository
import com.mfathurz.androidarchexample.core.ui.ViewModelFactory
import com.mfathurz.androidarchexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(Repository.getInstance())
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        viewModel.posts.observe(this, { list ->
            binding.textView.text = list.toString()
        })
    }
}