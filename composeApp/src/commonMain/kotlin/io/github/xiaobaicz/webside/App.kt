package io.github.xiaobaicz.webside

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import io.github.xiaobaicz.webside.navigation.NavHost
import io.github.xiaobaicz.webside.navigation.NavHostControllerProvider
import io.github.xiaobaicz.webside.navigation.Path
import io.github.xiaobaicz.webside.page.Home
import io.github.xiaobaicz.webside.page.Privacy
import io.github.xiaobaicz.webside.theme.WebSideTheme

@Composable
fun App() {
    WebSideTheme {
        NavHostControllerProvider {
            NavHost(startDestination = getRootPath()) {
                composable(Path.home) { Home() }
                composable(Path.privacy) { Privacy() }
            }
        }
    }
}