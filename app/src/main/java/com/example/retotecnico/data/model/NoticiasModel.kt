package com.example.retotecnico.data.model

import com.google.gson.annotations.SerializedName

data class NoticiasModel(
    @SerializedName("created_at")
    val created_at: String,

    @SerializedName("title")
    val title: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("author")
    val author: String,

    @SerializedName("points")
    val points: String?,

    @SerializedName("story_text")
    val story_text: String?,

    @SerializedName("comment_text")
    val comment_text: String,

    @SerializedName("num_comments")
    val num_comments: String?,

    @SerializedName("story_id")
    val story_id: Int,

)
