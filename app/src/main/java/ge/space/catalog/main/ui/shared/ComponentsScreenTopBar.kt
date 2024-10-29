package ge.space.catalog.main.ui.shared

import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import ge.space.catalog.main.navigation.LocalNavController
import androidx.compose.material.icons.Icons.Rounded as MIcons

/**
 * Composable function that displays the top app bar for a component screen.
 *
 * This top app bar includes a back button that navigates to the previous screen
 * using the [LocalNavController].
 *
 * @param title The title of the screen to be displayed in the top app bar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ComponentScreenTopBar(title: String) {
    val navigator = LocalNavController.current
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = { navigator.navigateUp() },
            ) {
                Icon(MIcons.ArrowBack, contentDescription = null)
            }
        }
    )
}