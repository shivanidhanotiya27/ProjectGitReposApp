package com.example.gitreposapp.model.response

import com.example.gitreposapp.model.GitRepository
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchRepositoriesResponse(
    @Json(name="total_count")
    val totalCount: Long? = null,
    @Json(name = "items")
    val repositories: List<GitRepository>? = null,
    @Json(name = "incomplete_results")
    val incomResult: Boolean? = null
)