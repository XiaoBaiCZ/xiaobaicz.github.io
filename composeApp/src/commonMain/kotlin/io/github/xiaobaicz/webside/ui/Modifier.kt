package io.github.xiaobaicz.webside.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.xiaobaicz.webside.theme.localColorScheme

@Composable
fun Modifier.page(
    background: Color = localColorScheme.background
): Modifier = fillMaxSize().background(background)

@Composable
fun Modifier.toolbar(
    height: Dp = 56.dp,
    color: Color = localColorScheme.theme,
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp),
): Modifier = fillMaxWidth().height(height).background(color).padding(paddingValues)

@Composable
fun Modifier.ifElse(
    cond: Boolean,
    yes: Modifier.() -> Modifier,
    no: Modifier.() -> Modifier,
): Modifier {
    return if (cond) yes() else no()
}