package io.github.xiaobaicz.webside.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.xiaobaicz.webside.ui.Content

@Composable
fun WebSideTheme(
    colorScheme: ColorScheme = webSideColorScheme,
    textStyleScheme: TextStyleScheme = webSideTextStyleScheme,
    content: Content
) {
    ColorSchemeProvider(colorScheme = colorScheme) {
        ContentColorProvider {
            TextStyleSchemeProvider(textStyleScheme = textStyleScheme) {
                ContentTextStyleProvider {
                    Box(modifier = Modifier.fillMaxSize().background(localColorScheme.background)) {
                        content()
                    }
                }
            }
        }
    }
}