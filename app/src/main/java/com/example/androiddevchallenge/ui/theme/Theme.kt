package com.example.androiddevchallenge.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

private val LightColorPalette = MyColors(
    welcomeBg = pink500,
    welcomeText = white4,
    accent = pink700,
    primary = pink500,
    filter = pink200,
    selected = pink700,
    itemBg = white
)

private val DarkColorPalette = MyColors(
    welcomeBg = teal700,
    welcomeText = white5,
    accent = teal500,
    primary = teal700,
    filter = teal200,
    selected = teal900,
    itemBg = white2
)

private val LocalMyColors = compositionLocalOf {
    LightColorPalette
}

@Stable
object MyTheme {
    val colors: MyColors
        @Composable
        get() = LocalMyColors.current

    enum class Theme {
        Light, Dark
    }
}

@Stable
class MyColors(
    welcomeBg: Color,
    welcomeText: Color,
    accent:Color,
    primary:Color,
    filter:Color,
    selected:Color,
    itemBg:Color
) {
    var welcomeBg: Color by mutableStateOf(welcomeBg)
    var welcomeText: Color by mutableStateOf(welcomeText)
    var accent:Color by mutableStateOf(accent)
    var primary:Color by mutableStateOf(primary)
    var filter:Color by mutableStateOf(filter)
    var selected:Color by mutableStateOf(selected)
    var itemBg:Color by mutableStateOf(itemBg)
}

@Composable
fun MyTheme(theme: MyTheme.Theme = MyTheme.Theme.Light, content: @Composable () -> Unit) {
    val targetColors = when (theme) {
        MyTheme.Theme.Light -> LightColorPalette
        MyTheme.Theme.Dark -> DarkColorPalette
    }
    val welcomeBg = animateColorAsState(targetColors.welcomeBg, TweenSpec(600))
    val welcomeText = animateColorAsState(targetColors.welcomeText, TweenSpec(600))
    val accent = animateColorAsState(targetColors.accent, TweenSpec(600))
    val primary = animateColorAsState(targetColors.primary, TweenSpec(600))
    val filter = animateColorAsState(targetColors.filter, TweenSpec(600))
    val selected = animateColorAsState(targetColors.selected, TweenSpec(600))
    val itemBg = animateColorAsState(targetColors.itemBg, TweenSpec(600))
    val colors = MyColors(
        welcomeBg = welcomeBg.value,
        welcomeText = welcomeText.value,
        accent = accent.value,
        primary = primary.value,
        filter = filter.value,
        selected = selected.value,
        itemBg = itemBg.value
    )

    CompositionLocalProvider(LocalMyColors provides colors) {
        MaterialTheme(
            shapes = shapes
        ) {
            ProvideWindowInsets(content = content)
        }
    }
}