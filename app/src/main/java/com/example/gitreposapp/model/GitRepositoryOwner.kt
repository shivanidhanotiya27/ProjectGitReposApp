package com.example.gitreposapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitRepositoryOwner(
    val id: Long,
    @Json(name = "login")
    val userName: String,
    @Json(name = "avatar_url")
    val url: String,
    @Json(name = "html_url")
    val profileUrl: String
    )

