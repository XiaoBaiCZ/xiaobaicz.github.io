package io.github.xiaobaicz.webside

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
actual fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        App()
    }
}