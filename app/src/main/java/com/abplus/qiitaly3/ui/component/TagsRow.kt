package com.abplus.qiitaly3.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abplus.qiitaly3.model.Tag

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagsRow(tags: List<Tag>) {
    FlowRow(
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ) {
        tags.map {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .border(1.dp, MaterialTheme.colorScheme.onSecondary),
                shape = CardDefaults.shape,
            ) {
                Text(
                    text = it.name,
                    modifier = Modifier
                        .padding(4.dp),
                    fontSize = 9.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun TagsRowPreview() {
    val tags = listOf(
        Tag("php"),
        Tag("Java"),
        Tag("Kotlin"),
    )
    TagsRow(tags = tags)
}