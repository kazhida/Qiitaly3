package com.abplus.qiitaly3.util

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable

class AssetReader(private val context: Context) {

    @Composable
    fun readFile(fileName: String): String {
//        val inputStream = context.assets.open(fileName)
//        return inputStream.bufferedReader().use {
//            it.readText()
//        }

        var text = ""

        try {
            val inputStream = context.assets.open(fileName)
            text = inputStream.bufferedReader().use {
                it.readText()
            }
        } catch (e: Exception) {
            Log.e("AssetReader", e.message ?: "")
        }
        return text
    }
}