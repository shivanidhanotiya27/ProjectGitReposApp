package com.example.gitreposapp.retrofit.service

import com.example.gitreposapp.model.SearchRepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPointService {

    @GET("search/repositories")
    fun getGitRepoSearchResults(
        @Query("q") searchQuery: String = "language:kotlin",
        @Query("pushed") lastUpdated: String = ":2024-04-01",
        @Query("sort") sortBy: String = "stars",
        @Query("order") orderBy: String = "desc",
        @Query("page") page: Int = 1,
        @Query("per_page") size: Int = 10
    ): SearchRepositoriesResponse
}