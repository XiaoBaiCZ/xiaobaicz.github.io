package io.github.xiaobaicz.webside.component

import androidx.compose.runtime.Composable

interface Component {

    val type: Any

    @Composable
    fun Content()

}