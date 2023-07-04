package io.github.xiaobaicz.webside.component

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import io.github.xiaobaicz.webside.theme.localContentColor
import io.github.xiaobaicz.webside.theme.localContentTextStyle

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(),
) {
    val textStyle = localContentTextStyle + TextStyle(color = localContentColor) + style
    BasicText(text, style = textStyle, modifier = modifier)
}

@Composable
fun Text(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(),
) {
    val textStyle = localContentTextStyle + TextStyle(color = localContentColor) + style
    BasicText(text, style = textStyle, modifier = modifier)
}
