package com.example.gitreposapp.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class GitRepositoryOwner(
    @Json(name = "id")
    val id: Long?,
    @Json(name = "login")
    val userName: String?,
    @Json(name = "avatar_url")
    val url: String?,
    @Json(name = "html_url")
    val profileUrl: String?
    ) : Parcelable

