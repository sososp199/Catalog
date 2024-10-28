package ge.space.catalog.main.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ge.space.catalog.SPDesignSystemComponents.components
import ge.space.catalog.SPDesignSystemComponents.foundation
import ge.space.catalog.main.ui.SPDesignSystemComponent
import ge.space.catalog.screens.MainScreen

internal val LocalNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

@Composable
internal fun NavGraph(
    onThemeToggle: (offset: Offset) -> Unit,
) {
    val density = LocalDensity.current
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            navController = navController,
            startDestination = MAIN_SCREEN_ROUTE,
            enterTransition = { SharedXAxisEnterTransition(density) },
            exitTransition = { SharedXAxisExitTransition(density) },
            popEnterTransition = { SharedXAxisPopEnterTransition(density) },
            popExitTransition = { SharedXAxisPopExitTransition(density) },
        ) {
            composable(MAIN_SCREEN_ROUTE) {
                MainScreen(navController::navigate, onThemeToggle)
            }
            addComposableRoutes((foundation + components))
        }
    }
}

internal fun NavGraphBuilder.addComposableRoutes(components: List<SPDesignSystemComponent>) {
    components.forEach { item ->
        composable(item.titleRes.toString()) {
            item.screen(item)
        }
        // Recursively add inner components
        if (item.innerComponents.isNotEmpty()) {
            addComposableRoutes(item.innerComponents)
        }
    }
}

private const val MAIN_SCREEN_ROUTE = "MAIN_ROUTE"