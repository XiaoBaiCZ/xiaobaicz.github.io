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

class DependentGroup private constructor(
    private val delegate: List<Dependent> = ArrayList(),
) : Component, List<Dependent> by delegate {

    init {
        if (delegate.isEmpty()) throw RuntimeException()
    }

    override val type: Any get() = "DependentGroup"

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.padding(vertical = 8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(localColorScheme.scope)
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = this@DependentGroup[0].name,
                style = localTextStyleScheme.title,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            )
            forEach {
                Text(
                    text = it.toString(),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 16.dp)
                )
            }
        }
    }

    override fun hashCode(): Int {
        val dependent = delegate[0]
        return dependent.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is DependentGroup) return false
        return delegate[0] == other[0]
    }

    companion object {
        fun build(vararg dependencies: Dependent): DependentGroup {
            return DependentGroup(dependencies.toList())
        }
    }

}