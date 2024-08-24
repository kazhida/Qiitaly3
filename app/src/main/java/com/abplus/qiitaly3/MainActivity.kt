package com.abplus.qiitaly3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abplus.qiitaly3.ui.component.Loading
import com.abplus.qiitaly3.ui.component.MainAppBar
import com.abplus.qiitaly3.ui.component.SearchAppBar
import com.abplus.qiitaly3.ui.screen.ArticleListScreen
import com.abplus.qiitaly3.ui.theme.Qiitaly3Theme
import com.abplus.qiitaly3.viewmodel.ArticlesViewModel

@OptIn(ExperimentalMaterialApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Qiitaly3Theme {
                val viewModel: ArticlesViewModel = viewModel()
                val pullState = rememberPullRefreshState(
                    refreshing = viewModel.isLoading,
                    onRefresh = {
                        viewModel.reload()
                    }
                )
                if (viewModel.isInitial) {
                    viewModel.reload()
                }
                var searchMode by remember {
                    mutableStateOf(false)
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        if (searchMode) {
                            SearchAppBar(
                                onSearch = {
                                    viewModel.search(it)
                                    //LocalSoftwareKeyboardController.current?.hide()
                                },
                                onCancel = {
                                    searchMode = false
                                }
                            )
                        } else {
                            MainAppBar(
                                onSearchButton = {
                                    searchMode = true
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .pullRefresh(pullState)
                    ) {
                        when (viewModel.loadingState.value) {
                            ArticlesViewModel.LoadingState.INITIAL -> {}
                            ArticlesViewModel.LoadingState.LOADING -> Loading()
                            ArticlesViewModel.LoadingState.LOADED -> ArticleListScreen(modifier = Modifier.padding(innerPadding))
                            ArticlesViewModel.LoadingState.ERROR_OCCURRED -> Text(text = "Error")
                        }
                    }
                }
            }
        }
    }
}
