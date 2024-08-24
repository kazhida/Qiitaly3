package com.abplus.qiitaly3.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.abplus.qiitaly3.R
import com.abplus.qiitaly3.model.Article
import com.abplus.qiitaly3.model.User

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ArticleCard(article: Article) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White),
    ) {
        Column {
            Row {
                AsyncImage(
                    modifier = Modifier
                        .size(72.dp)
                        .aspectRatio(1f)
                        .padding(8.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(article.user.profileImageUrl)
                        .crossfade(true)
                        .diskCachePolicy(CachePolicy.DISABLED)
                        .transformations(
                            CircleCropTransformation()
                        )
                        .build(),
                    placeholder = painterResource(id = R.drawable.now_loading),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "@${article.user.id}",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = article.user.name,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            article.tags?.let {
                TagsRow(tags = it)
            }
            Text(
                text = article.title,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Text(
                text = article.updatedAt,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview(widthDp = 160)
@Composable
private fun ArticleCardPreview() {
    Article(
        id = "",
        title = "Qiitaを読むアプリをJetpack Composeで作ってみた。",
        body = "",
        renderedBody = "",
        url = "",
        commentsCount = 0,
        likesCountInt = 0,
        reactionsCount = 0,
        stocksCount = 0,
        pageViewsCount = 0,
        user = User(
            permanentId = 1,
            id = "kazhida",
            name = "Kazuyuki HIDA",
            description = "",
            profileImageUrl = "https://qiita-user-profile-images.imgix.net/https%3A%2F%2Fqiita-image-store.s3.ap-northeast-1.amazonaws.com%2F0%2F13886%2Fprofile-images%2F1624422561?ixlib=rb-4.0.0&auto=compress%2Cformat&lossless=0&w=128&s=6d163cd783a45275b94e8ec6c5b3c43e",
            location = "",
            followeesCount = 0,
            followersCount = 0,
            itemsCount = 0,
            teamOnly = false,
    ),
        tags = listOf(),
        private = false,
        slide = false,
        createdAt = "",
        updatedAt = ""
    ).let {
        ArticleCard(article = it)
    }
}

