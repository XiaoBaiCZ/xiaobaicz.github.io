package io.github.xiaobaicz.webside

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.w3c.dom.url.URL

@OptIn(ExperimentalComposeUiApi::class)
actual fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        App()
    }
}

private fun getWebUrl(): String = js("window.location.href")

actual fun getRootPath(): String {
    return URL(getWebUrl()).pathname
}