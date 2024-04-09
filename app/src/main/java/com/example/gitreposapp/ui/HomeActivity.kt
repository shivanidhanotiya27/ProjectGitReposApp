package com.example.gitreposapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.gitreposapp.databinding.ActivityHomeBinding
import com.example.gitreposapp.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private var binding: ActivityHomeBinding? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private var repoAdapter: RepositoriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        init()
        collectUiState()
    }
    private fun init(){
        repoAdapter = RepositoriesAdapter()
        binding?.repoRecyclerView?.adapter = repoAdapter
    }

    private fun collectUiState() {
       this.lifecycleScope.launch {
           homeViewModel.repositories.collectLatest { repos ->
               repoAdapter?.submitData(repos)
           }
       }
    }

    override fun onDestroy() {
       super.onDestroy()
        repoAdapter = null
        binding = null
    }
}