package com.example.gitreposapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchRepositoriesResponse(
    @Json(name="total_count")
    val totalCount: Long,
    @Json(name = "items")
    val repositories: List<GitRepository>
)