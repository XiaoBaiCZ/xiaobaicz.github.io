package io.github.xiaobaicz.webside.ui

import androidx.compose.runtime.Composable

typealias Content = @Composable () -> Unit

typealias TypeContent<T> = @Composable T.() -> Unit