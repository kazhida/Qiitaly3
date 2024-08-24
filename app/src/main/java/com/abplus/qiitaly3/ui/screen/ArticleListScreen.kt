package com.abplus.qiitaly3.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abplus.qiitaly3.ui.component.ArticleCard
import com.abplus.qiitaly3.viewmodel.ArticlesViewModel

@Composable
fun ArticleListScreen(modifier: Modifier = Modifier) {
    val articles: ArticlesViewModel = viewModel()

    LazyColumn() {
        items(items = articles.articles) { article ->
            ArticleCard(article = article)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ArticleListScreenPreview() {
    ArticleListScreen()
}
