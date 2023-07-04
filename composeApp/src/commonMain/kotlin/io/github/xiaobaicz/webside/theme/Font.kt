package io.github.xiaobaicz.webside.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import io.github.xiaobaicz.webside.ui.Content

data class TextStyleScheme(
    val title: TextStyle,
    val content: TextStyle,
)

val webSideTextStyleScheme = TextStyleScheme(
    title = newTextStyle(fontSize = 22.5.sp, lineHeight = 29.sp, fontWeight = FontWeight.W400),
    content = newTextStyle(fontSize = 16.sp, lineHeight = 24.sp, fontWeight = FontWeight.W400),
)

@Composable
fun TextStyleSchemeProvider(textStyleScheme: TextStyleScheme = localTextStyleScheme, content: Content) {
    CompositionLocalProvider(value = LocalTextStyleScheme provides textStyleScheme) {
        content()
    }
}

@Composable
fun ContentTextStyleProvider(textStyle: TextStyle = localTextStyleScheme.content, content: Content) {
    CompositionLocalProvider(value = LocalContentTextStyle provides textStyle) {
        content()
    }
}

val LocalTextStyleScheme = staticCompositionLocalOf { webSideTextStyleScheme }

val LocalContentTextStyle = staticCompositionLocalOf { webSideTextStyleScheme.content }

val localTextStyleScheme @Composable get() = LocalTextStyleScheme.current

val localContentTextStyle @Composable get() = LocalContentTextStyle.current

private fun newTextStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight? = null,
    fontStyle: FontStyle? = null,
    textAlign: TextAlign = TextAlign.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    shadow: Shadow? = null,
    textDecoration: TextDecoration? = null,
    platformStyle: PlatformTextStyle? = null,
): TextStyle {
    return TextStyle(
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        lineHeight = lineHeight,
        textAlign = textAlign,
        letterSpacing = letterSpacing,
        shadow = shadow,
        textDecoration = textDecoration,
        platformStyle = platformStyle,
        lineHeightStyle = LineHeightStyle(
            LineHeightStyle.Alignment.Center,
            LineHeightStyle.Trim.None
        )
    )
}