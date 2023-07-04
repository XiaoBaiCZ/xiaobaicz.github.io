package io.github.xiaobaicz.webside.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Indication
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.xiaobaicz.webside.runtime.rememberMutableStateOf
import io.github.xiaobaicz.webside.foundation.IndicationProvider
import io.github.xiaobaicz.webside.foundation.WebSideButtonIndication
import io.github.xiaobaicz.webside.theme.ContentColorProvider
import io.github.xiaobaicz.webside.theme.localColorScheme
import io.github.xiaobaicz.webside.theme.localContentColor
import io.github.xiaobaicz.webside.ui.TypeContent

typealias OnClick = () -> Unit

@Stable
class StateColor(
    val default: Color = Color.White,
    val focus: Color = default,
    val select: Color = default,
    val disable: Color = default.copy(alpha = 0.8f),
)

val LocalButtonColor = staticCompositionLocalOf { StateColor() }

inline val localButtonColor @Composable get() = LocalButtonColor.current

@Stable
class StatePainter(
    val default: Painter,
    val focus: Painter = default,
    val select: Painter = default,
    val disable: Painter = default,
)

@Composable
fun rememberStatePainter(
    default: Painter,
    focus: Painter = default,
    select: Painter = default,
    disable: Painter = default,
): StatePainter {
    return remember(default, focus, select, disable) {
        StatePainter(default, focus, select, disable)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Button(
    onClick: OnClick,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onLongClick: OnClick? = null,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    contentAlignment: Alignment = Alignment.CenterStart,
    content: TypeContent<BoxScope>
) {
    Box(
        modifier = modifier.combinedClickable(
            onClick = onClick,
            enabled = enabled,
            onLongClick = onLongClick,
        ).padding(paddingValues),
        contentAlignment = contentAlignment
    ) {
        content()
    }
}

@Composable
fun LabelButton(
    onClick: OnClick,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onLongClick: OnClick? = null,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    contentAlignment: Alignment = Alignment.CenterStart,
    select: State<Boolean>? = null,
    color: StateColor = StateColor(
        default = localColorScheme.content,
        focus = localColorScheme.theme
    ),
    content: TypeContent<BoxScope>
) {
    var focus by rememberMutableStateOf { false }
    ContentColorProvider(
        when {
            !enabled -> color.disable
            focus -> color.focus
            select?.value == true -> color.select
            else -> color.default
        }
    ) {
        Button(
            onClick,
            modifier.onFocusChanged { focus = it.isFocused },
            enabled,
            onLongClick,
            paddingValues,
            contentAlignment,
            content
        )
    }
}

@Composable
fun ViuButton(
    onClick: OnClick,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onLongClick: OnClick? = null,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    contentAlignment: Alignment = Alignment.CenterStart,
    select: State<Boolean>? = null,
    color: StateColor = StateColor(
        default = localColorScheme.content,
        focus = localColorScheme.button,
    ),
    buttonColor: StateColor = StateColor(
        default = localColorScheme.button,
        focus = localColorScheme.theme
    ),
    shape: Shape = RoundedCornerShape(2.dp),
    indication: Indication? = null,
    content: TypeContent<BoxScope>
) {
    CompositionLocalProvider(value = LocalButtonColor provides buttonColor) {
        IndicationProvider(indication ?: remember(enabled, select) {
            WebSideButtonIndication(
                enabled,
                select
            )
        }) {
            LabelButton(
                onClick,
                modifier.clip(shape = shape),
                enabled,
                onLongClick,
                paddingValues,
                contentAlignment,
                select,
                color,
                content
            )
        }
    }
}

@Composable
fun ViuIconButton(
    onClick: OnClick,
    painter: StatePainter,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onLongClick: OnClick? = null,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    contentAlignment: Alignment = Alignment.CenterStart,
    select: State<Boolean>? = null,
    color: StateColor = StateColor(
        default = localColorScheme.content,
        focus = localColorScheme.button
    ),
    buttonColor: StateColor = StateColor(
        default = localColorScheme.button,
        focus = localColorScheme.theme
    ),
    shape: Shape = RoundedCornerShape(2.dp),
    indication: Indication? = null,
    iconPadding: Dp = 8.dp,
    content: TypeContent<RowScope>
) {
    var focus by rememberMutableStateOf { false }
    ViuButton(
        onClick,
        modifier.onFocusChanged { focus = it.isFocused },
        enabled,
        onLongClick,
        paddingValues,
        contentAlignment,
        select,
        color,
        buttonColor,
        shape,
        indication
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = when {
                    !enabled -> painter.disable
                    focus -> painter.focus
                    select?.value == true -> painter.select
                    else -> painter.default
                },
                tint = localContentColor,
                modifier = Modifier.padding(end = iconPadding)
            )
            content()
        }
    }
}

@Composable
fun ViuIconButton(
    onClick: OnClick,
    painter: Painter,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onLongClick: OnClick? = null,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    contentAlignment: Alignment = Alignment.CenterStart,
    select: State<Boolean>? = null,
    color: StateColor = StateColor(
        default = localColorScheme.content,
        focus = localColorScheme.button
    ),
    buttonColor: StateColor = StateColor(
        default = localColorScheme.button,
        focus = localColorScheme.theme
    ),
    shape: Shape = RoundedCornerShape(2.dp),
    indication: Indication? = null,
    iconPadding: Dp = 8.dp,
    content: TypeContent<RowScope>
) {
    ViuIconButton(
        onClick,
        rememberStatePainter(default = painter),
        modifier,
        enabled,
        onLongClick,
        paddingValues,
        contentAlignment,
        select,
        color,
        buttonColor,
        shape,
        indication,
        iconPadding,
        content
    )
}
