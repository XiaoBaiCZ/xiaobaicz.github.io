package io.github.xiaobaicz.webside

class WasmPlatform : Platform() {
    override val name: String = WEB
}

actual fun getPlatform(): Platform = WasmPlatform()