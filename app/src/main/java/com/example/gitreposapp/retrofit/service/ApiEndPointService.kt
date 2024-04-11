package com.example.gitreposapp.retrofit.service

import com.example.gitreposapp.model.response.SearchRepositoriesResponse
import com.example.gitreposapp.model.response.error.ErrorResponse
import com.example.gitreposapp.retrofit.networkAdapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPointService {

    @GET("search/repositories")
    suspend fun getGitRepoSearchResults(
        @Query("q") searchQuery: String = "language:kotlin",
        @Query("sort") sortBy: String = "stars",
        @Query("order") orderBy: String = "desc",
        @Query("page") page: Int = 1,
        @Query("per_page") size: Int = 10
    ): SearchRepositoriesResponse
}

typealias APIResponse<S> = NetworkResponse<S, ErrorResponse>