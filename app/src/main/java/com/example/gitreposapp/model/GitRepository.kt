package com.example.gitreposapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitRepository (
    val id: Long? = null,
    val name: String? = null,
    val owner: GitRepositoryOwner? = null,
    @Json(name = "html_url")
    val url: String? = null,
    val description: String? = null,
    @Json(name = "stargazers_count")
    val numberOfStars: Long? = null,
    @Json(name = "language")
    val programmingLanguage: String? = null
)