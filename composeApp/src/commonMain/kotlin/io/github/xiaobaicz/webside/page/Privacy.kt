package io.github.xiaobaicz.webside.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.xiaobaicz.webside.component.Text
import io.github.xiaobaicz.webside.theme.localTextStyleScheme
import io.github.xiaobaicz.webside.ui.page
import io.github.xiaobaicz.webside.ui.toolbar

@Composable
fun Privacy() {
    Column(modifier = Modifier.page()) {
        Row(modifier = Modifier.toolbar(), verticalAlignment = Alignment.CenterVertically) {
            Text("Privacy", style = localTextStyleScheme.title)
        }
        PrivacyItem(
            title = "1. User data",
            body = "Not accessed, collected, used or shared"
        )
        PrivacyItem(
            title = "2. Sensitive information access rights and APIs",
            body = "No sensitive information access rights and APIs"
        )
        PrivacyItem(
            title = "3. Device and network misuse",
            body = "No device and network abuse"
        )
    }
}

@Composable
private fun PrivacyItem(title: String, body: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = title,
            style = localTextStyleScheme.title,
        )
        Text(text = body, modifier = Modifier.padding(top = 16.dp))
    }
}
