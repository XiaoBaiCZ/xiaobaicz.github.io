package io.github.xiaobaicz.webside.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.xiaobaicz.webside.component.Component
import io.github.xiaobaicz.webside.component.Text
import io.github.xiaobaicz.webside.entity.Dependent
import io.github.xiaobaicz.webside.entity.DependentGroup
import io.github.xiaobaicz.webside.runtime.rememberMutableStateListOf
import io.github.xiaobaicz.webside.theme.localTextStyleScheme
import io.github.xiaobaicz.webside.ui.page
import io.github.xiaobaicz.webside.ui.toolbar
import kotlinx.coroutines.delay

@Composable
fun Home() {
    Column(modifier = Modifier.page()) {
        Row(modifier = Modifier.toolbar(), verticalAlignment = Alignment.CenterVertically) {
            Text("Home", style = localTextStyleScheme.title)
        }
        SelectionContainer {
            val components = rememberMutableStateListOf<Component>()
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(components, contentType = { it.type }) {
                    it.Content()
                }
            }
            LaunchedEffect(Unit) {
                components.addAll(loadDependencies())
            }
        }
    }
}

private suspend fun loadDependencies(): List<Component> {
    delay(200L)
    return listOf(
        Dependent(name = "common", version = "0.0.7"),
        Dependent(name = "initializer", version = "0.0.3"),
        DependentGroup.build(
            Dependent(name = "store", version = "1.1.1"),
            Dependent(name = "store-mem", version = "1.1.1"),
            Dependent(name = "store-mmkv", version = "1.1.1"),
            Dependent(name = "store-serialize-gson", version = "1.1.1"),
        ),
        Dependent(name = "recyclerview-extend", version = "2.0.0"),
        Dependent(name = "text", version = "1.2.0"),
        DependentGroup.build(
            Dependent(name = "log", version = "0.0.2"),
            Dependent(name = "log-android", version = "0.0.2", func = "debugImplementation"),
        ),
        DependentGroup.build(
            Dependent(group = "com.google.auto.service", name = "auto-service-annotations", version = "1.1.1"),
            Dependent(group = "com.google.auto.service", name = "auto-service", version = "1.1.1", func = "kapt"),
        ),
    )
}