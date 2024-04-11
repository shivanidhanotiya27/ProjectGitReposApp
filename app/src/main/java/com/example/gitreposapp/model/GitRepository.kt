package com.example.gitreposapp.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class GitRepository (
    @Json(name = "id")
    val id: Long?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "owner")
    val owner: GitRepositoryOwner?,
    @Json(name = "html_url")
    val url: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "stargazers_count")
    val numberOfStars: Long?,
    @Json(name = "language")
    val programmingLanguage: String?
) : Parcelable