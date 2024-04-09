package com.example.gitreposapp.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gitreposapp.model.GitRepository
import com.example.gitreposapp.retrofit.service.ApiEndPointService

const val FIRST_PAGE = 1

class RepositorySource(
    private val apiEndPointService: ApiEndPointService,
    private val searchQuery: String = "language:kotlin",
    private val lastUpdated: String = ":2024-04-01",
    private val sortBy: String = "stars",
    private val orderBy: String = "desc",
) : PagingSource<Int, GitRepository>() {

    override fun getRefreshKey(state: PagingState<Int, GitRepository>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitRepository> {
       return try{
            val page = params.key ?: FIRST_PAGE

            val response = apiEndPointService.getGitRepoSearchResults(
                searchQuery = searchQuery,
                lastUpdated = lastUpdated,
                sortBy = sortBy,
                orderBy = orderBy,
                page = page, size = params.loadSize)

            LoadResult.Page(
                data = response.repositories,
                prevKey = if(page == FIRST_PAGE) null else page -1,
                nextKey = if(response.repositories.isEmpty()) null else page + 1
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}