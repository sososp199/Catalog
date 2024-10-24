package ge.space.catalog.main.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp


internal val SharedXAxisPopEnterTransition: (Density) -> EnterTransition = { density ->
    fadeIn(
        animationSpec = tween(
            durationMillis = 210, delayMillis = 90, easing = LinearOutSlowInEasing
        )
    ) + slideInHorizontally(animationSpec = tween(durationMillis = 300)) {
        with(density) { (-30).dp.roundToPx() }
    }
}

internal val SharedXAxisExitTransition: (Density) -> ExitTransition = { density ->
    fadeOut(
        animationSpec = tween(
            durationMillis = 90, easing = FastOutLinearInEasing
        )
    ) + slideOutHorizontally(animationSpec = tween(durationMillis = 300)) {
        with(density) { (-30).dp.roundToPx() }
    }
}

internal val SharedXAxisPopExitTransition: (Density) -> ExitTransition = { density ->
    fadeOut(
        animationSpec = tween(
            durationMillis = 90, easing = FastOutLinearInEasing
        )
    ) + slideOutHorizontally(animationSpec = tween(durationMillis = 300)) {
        with(density) { 30.dp.roundToPx() }
    }
}

internal val SharedXAxisEnterTransition: (Density) -> EnterTransition = { density ->
    fadeIn(
        animationSpec = tween(
            durationMillis = 210, delayMillis = 90, easing = LinearOutSlowInEasing
        )
    ) + slideInHorizontally(animationSpec = tween(durationMillis = 300)) {
        with(density) { 30.dp.roundToPx() }
    }
}
