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
import ge.space.catalog.DesignSystemComponents.components
import ge.space.catalog.DesignSystemComponents.foundation
import ge.space.catalog.main.ui.DesignSystemComponent
import ge.space.catalog.screens.ComponentsMainScreen

/**
 * A CompositionLocal that provides a [NavHostController] instance.
 *
 * This allows composables to access the [NavHostController] and navigate to
 * different destinations in the navigation graph.
 *
 * Throws an error if no [NavHostController] is provided.
 */
internal val LocalNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

/**
 * Composable function that sets up the navigation graph for the application.
 *
 * This function uses a [NavHost] to manage navigation between different composables.
 * It also provides the [LocalNavController] to the composables in the navigation graph.
 *
 * @param onThemeToggle A callback function to toggle the theme.
 */
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
                ComponentsMainScreen(navController::navigate, onThemeToggle)
            }
            addComposableRoutes((foundation + components))
        }
    }
}

/**
 * Adds composable routes to the [NavGraphBuilder] for the given list of [DesignSystemComponent]s.
 *
 * This function iterates through the list of components and adds a composable route for each one.
 * It also recursively adds routes for any inner components.
 *
 * @param components The list of components to add routes for.
 */
internal fun NavGraphBuilder.addComposableRoutes(components: List<DesignSystemComponent>) {
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

/**
 * The route for the main screen.
 */
private const val MAIN_SCREEN_ROUTE = "MAIN_ROUTE"