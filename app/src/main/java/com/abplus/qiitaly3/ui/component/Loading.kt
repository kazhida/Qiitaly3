package com.abplus.qiitaly3.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.abplus.qiitaly3.R

@Composable
fun Loading() {
    Image(
        painter = painterResource(id = R.drawable.now_loading),
        contentDescription = "Loading...",
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
private fun LoadingPreview() {
    Loading()
}
