package com.example.gitreposapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitRepository (
    val id: Long,
    val name: String,
    val owner: GitRepositoryOwner,
    @Json(name = "html_url")
    val url: String,
    val description: String,
    @Json(name = "stargazers_count")
    val numberOfStars: Long,
    @Json(name = "language")
    val programmingLanguage: String
)