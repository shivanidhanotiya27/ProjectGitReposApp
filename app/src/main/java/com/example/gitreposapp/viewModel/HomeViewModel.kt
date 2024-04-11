package com.example.gitreposapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gitreposapp.model.GitRepository
import com.example.gitreposapp.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val homeRepository: HomeRepository
): ViewModel() {

    private val _searchQuery = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val repositories: Flow<PagingData<GitRepository>> = _searchQuery
        .filter { it.isNotBlank() }
        .flatMapLatest { query ->
            homeRepository.searchRepositories(searchQuery = query)
                .cachedIn(viewModelScope)
        }

    fun searchRepositories(query: String) {
        _searchQuery.value = query
    }

}