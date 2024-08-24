package com.abplus.qiitaly3.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("permanent_id")
    val permanentId: Int,
    val id: String,
    val name: String,
    val description: String? = "",
    @SerialName("profile_image_url")
    val profileImageUrl: String,
    val location: String? = "",
    @SerialName("followees_count")
    val followeesCount: Int,
    @SerialName("followers_count")
    val followersCount: Int,
    @SerialName("items_count")
    val itemsCount: Int,
    @SerialName("team_only")
    val teamOnly: Boolean,
    val organization: String? = null,
    @SerialName("facebook_id")
    val facebookId: String? = null,
    @SerialName("github_login_name")
    val githubLoginName: String? = null,
    @SerialName("linked_in")
    val linkedIn: String? = null,
    @SerialName("twitter_screen_name")
    val twitterScreenName: String? = null,
    val website:String? = null
)
