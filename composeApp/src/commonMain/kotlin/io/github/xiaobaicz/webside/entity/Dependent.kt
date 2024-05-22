package io.github.xiaobaicz.webside.entity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.github.xiaobaicz.webside.component.Component
import io.github.xiaobaicz.webside.component.Text
import io.github.xiaobaicz.webside.theme.localColorScheme
import io.github.xiaobaicz.webside.theme.localTextStyleScheme

class Dependent(
    val group: String = "io.github.xiaobaicz",
    val name: String,
    val version: String,
    val func: String = "implementation",
) : Component {

    override val type: Any get() = "Dependent"

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.padding(vertical = 8.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(localColorScheme.scope)
        ) {
            Text(
                text = name,
                style = localTextStyleScheme.title,
                modifier = Modifier.padding(horizontal = 16.dp).padding(top = 16.dp)
            )
            Text(
                text = this@Dependent.toString(),
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    override fun hashCode(): Int {
        return group.hashCode() + name.hashCode() shl 1 + version.hashCode() shl 2 + func.hashCode() shl 3
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Dependent) return false
        if (other.group != group) return false
        if (other.name != name) return false
        if (other.version != version) return false
        if (other.func != func) return false
        return true
    }

    override fun toString(): String {
        return "$func(\"$group:$name:$version\")"
    }

}
