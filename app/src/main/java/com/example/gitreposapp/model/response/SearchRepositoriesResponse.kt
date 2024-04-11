package com.example.gitreposapp.model.response


import android.os.Parcelable
import com.example.gitreposapp.model.GitRepository
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class SearchRepositoriesResponse(
    @Json(name="total_count")
    val totalCount: Long?,
    @Json(name = "items")
    val repositories: List<GitRepository>?,
    @Json(name = "incomplete_results")
    val incomResult: Boolean?
) : Parcelable