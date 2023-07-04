package io.github.xiaobaicz.webside

abstract class Platform {
    abstract val name: String
    companion object {
        const val WEB = "Web with Kotlin/Wasm"
    }
}

expect fun getPlatform(): Platform