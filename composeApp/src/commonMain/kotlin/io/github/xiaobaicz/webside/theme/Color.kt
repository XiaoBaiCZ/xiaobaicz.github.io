package io.github.xiaobaicz.webside.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import io.github.xiaobaicz.webside.ui.Content

data class ColorScheme(
    val theme: Color,
    val content: Color,
    val background: Color,
    val button: Color,
    val scope: Color,
)

val webSideColorScheme = ColorScheme(
    theme = Color(color = 0xff6fa7ff),
    content = Color(color = 0xff333333),
    background = Color(color = 0xfffafafa),
    button = Color(color = 0xff333333),
    scope = Color(color = 0xffdddddd),
)

@Composable
fun ColorSchemeProvider(colorScheme: ColorScheme = localColorScheme, content: Content) {
    CompositionLocalProvider(value = LocalColorScheme provides colorScheme) {
        content()
    }
}

@Composable
fun ContentColorProvider(color: Color = localColorScheme.content, content: Content) {
    CompositionLocalProvider(value = LocalContentColor provides color) {
        content()
    }
}

val LocalColorScheme = staticCompositionLocalOf { webSideColorScheme }

val LocalContentColor = staticCompositionLocalOf { webSideColorScheme.content }

val localColorScheme @Composable get() = LocalColorScheme.current

val localContentColor @Composable get() = LocalContentColor.current