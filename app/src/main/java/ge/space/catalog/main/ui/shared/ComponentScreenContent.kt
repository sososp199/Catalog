package ge.space.catalog.main.ui.shared

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

/**
 * Composable function that displays the content of a component screen.
 *
 * This function provides a basic layout for a component screen, including a top app bar with
 * the provided title and a content area where the [content] composable is displayed.
 *
 * @param title The string resource ID for the title of the screen.
 * @param content The composable content to be displayed on the screen.
 */
@Composable
internal fun ComponentScreenContent(
    @StringRes title: Int,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            ComponentScreenTopBar(stringResource(title))
        },
    ) { contentPadding: PaddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(contentPadding),
        ) {
            content()
        }
    }
}