package com.abplus.qiitaly3.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abplus.qiitaly3.model.Article
import fuel.Fuel
import fuel.Parameters
import fuel.Request
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel : ViewModel() {
    val articles = mutableStateListOf<Article>()

    enum class LoadingState {
        INITIAL,
        LOADING,
        LOADED,
        ERROR_OCCURRED
    }

    val loadingState = mutableStateOf(LoadingState.INITIAL)

    val isLoading: Boolean get() = loadingState.value == LoadingState.LOADING
    val isInitial: Boolean get() = loadingState.value == LoadingState.INITIAL

    fun reload(bearer: String) {
        query(listOf(), bearer)
    }

    fun search(search: String, bearer: String) {
        query(listOf("query" to "title:${search}"), bearer)
    }

    private fun query(parameters: Parameters, bearer: String) {
        viewModelScope.launch {
            loadingState.value = LoadingState.LOADING
            val request = Request.Builder()
                .url("https://qiita.com/api/v2/items")
                .headers(
                    mapOf(
                        "Authorization" to bearer
                    )
                )
                .parameters(parameters)
                .build()
            val loader = Fuel.loader()
            val response = loader.get(request)

            val json = Json { ignoreUnknownKeys = true }
            try {
                val result = json.decodeFromString<List<Article>>(response.body)
                articles.apply {
                    clear()
                    addAll(result)
                    loadingState.value = LoadingState.LOADED
                }
                Log.d("ArticlesViewModel", parameters.size.toString() + result[0].title)
            } catch (e: Throwable) {
                Log.e("fetch failed", e.message ?: "")
                loadingState.value = LoadingState.ERROR_OCCURRED
            }
        }
    }
}
