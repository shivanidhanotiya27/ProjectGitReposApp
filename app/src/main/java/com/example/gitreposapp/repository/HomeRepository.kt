package com.example.gitreposapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.gitreposapp.retrofit.service.ApiEndPointService
import javax.inject.Inject


class HomeRepository @Inject constructor(
    private val apiEndPointService: ApiEndPointService
) {

    fun searchRepositories(
        searchQuery: String = "language:kotlin",
        sortBy: String = "stars",
        orderBy: String = "desc"
    ) = Pager(config = PagingConfig(pageSize = 10, prefetchDistance = 30)){
       RepositorySource(apiEndPointService, searchQuery,sortBy,orderBy)
    }.flow
}

