package com.example.gitreposapp.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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
    }
    private fun init(){
        repoAdapter = RepositoriesAdapter()
        binding?.repoRecyclerView?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding?.repoRecyclerView?.adapter = repoAdapter

        binding?.searchRepoItem?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    homeViewModel.searchRepositories(query)
                }
              return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    homeViewModel.searchRepositories(newText)
                }
               return false

            }

        })
    }

    override fun onResume() {
        super.onResume()
        observer()
    }

    private fun observer() {
        this.lifecycleScope.launch  {
           homeViewModel.repositories.collectLatest { repos ->
               binding?.repoRecyclerView?.visibility = View.VISIBLE
               binding?.noDataText?.visibility = View.GONE
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