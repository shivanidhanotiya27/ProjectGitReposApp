package com.example.gitreposapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gitreposapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_details)
    }
}