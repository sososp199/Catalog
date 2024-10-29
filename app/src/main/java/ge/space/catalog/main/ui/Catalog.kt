package ge.space.catalog.main.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import ge.space.catalog.main.navigation.NavGraph
import ge.space.catalog.main.ui.theme.AnimatedAppTheme

@Composable
internal fun Catalog(activity: MainActivity) {
    var isLightThemeUser by rememberSaveable { mutableStateOf<Boolean?>(null) }
    val isLightThemeFinal = isLightThemeUser ?: !isSystemInDarkTheme()

    AnimatedAppTheme(
        isLightTheme = isLightThemeFinal,
        onThemeToggle = { isLight ->
            isLightThemeUser = isLight
            activity.setUiMode(isLight)
        },
    ) { onThemeToggle ->
        NavGraph(onThemeToggle)
    }
}