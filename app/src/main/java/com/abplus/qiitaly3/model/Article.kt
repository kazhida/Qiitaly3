package com.abplus.qiitaly3.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: String,
    val title: String,
    val body: String,
    @SerialName("rendered_body")
    val renderedBody: String,
    val url: String,
    @SerialName("comments_count")
    val commentsCount: Int? = 0,
    @SerialName("likes_count_int")
    val likesCountInt: Int? = 0,
    @SerialName("reactions_count")
    val reactionsCount: Int? = 0,
    @SerialName("stocks_count")
    val stocksCount: Int? = 0,
    @SerialName("page_views_count")
    val pageViewsCount: Int? = 0,
    val user: User,
    val tags: List<Tag>? = listOf(),
    val private: Boolean,
    val slide: Boolean,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)
