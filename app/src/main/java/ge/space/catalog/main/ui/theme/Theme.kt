package ge.space.catalog.main.ui.theme

import android.os.Build
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import ge.space.catalog.main.utils.CirclePath

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

// Inspired by https://github.com/sanathsajeevakumara/ThemePickerAnimation
@Composable
internal fun AnimatedAppTheme(
    isLightTheme: Boolean,
    onThemeToggle: (Boolean) -> Unit,
    content: @Composable (onToggleTheme: (offset: Offset) -> Unit) -> Unit,
) {
    var animationOffset by remember { mutableStateOf(Offset(0f, 0f)) }
    AnimatedContent(
        targetState = isLightTheme,
        modifier = Modifier
            .fillMaxSize(),
        transitionSpec = {
            fadeIn(
                initialAlpha = 0f,
                animationSpec = tween(100),
            ) togetherWith fadeOut(
                targetAlpha = .9f,
                animationSpec = tween(800),
            )
        },
        label = "AppThemeChange",
    ) { currentTheme ->
        val revealSize = remember { Animatable(1f) }
        LaunchedEffect(Unit) {
            if (animationOffset.x > 0f) {
                revealSize.snapTo(0f)
                revealSize.animateTo(1f, animationSpec = tween(800))
            } else {
                revealSize.snapTo(1f)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CirclePath(revealSize.value, animationOffset)),
        ) {
            CatalogTheme(darkTheme = currentTheme.not()) {
                content { offset ->
                    animationOffset = offset
                    onThemeToggle(!currentTheme)
                }
            }
        }
    }
}

@Composable
internal fun CatalogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}