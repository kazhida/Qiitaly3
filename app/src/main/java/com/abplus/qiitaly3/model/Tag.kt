package com.abplus.qiitaly3.model

import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val name: String,
    val versions: List<String> = emptyList()
)
