package ge.space.catalog.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ge.space.catalog.SPDesignSystemComponents.controls
import ge.space.catalog.SPDesignSystemComponents.foundation
import ge.space.catalog.screens.MainScreen
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class, ExperimentalComposeUiApi::class)
@Composable
internal fun NavGraph(
    onThemeToggle: (offset: Offset) -> Unit,
) {
    val density = LocalDensity.current
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Main",
        enterTransition = { SharedXAxisEnterTransition(density) },
        exitTransition = { SharedXAxisExitTransition(density) },
        popEnterTransition = { SharedXAxisPopEnterTransition(density) },
        popExitTransition = { SharedXAxisPopExitTransition(density) },
    ) {
        composable("Main") {
            MainScreen(navController::navigate, onThemeToggle)
        }

        (foundation + controls).forEach { item ->
            composable(item.title) {
                item.screen(navController::navigateUp)
            }
        }
    }
}