package ge.space.catalog.main.ui.shared

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * Data class representing a menu item with a title and an action.
 *
 * @property title The string resource ID for the title of the menu item.
 * @property onClick The action to be performed when the menu item is clicked.
 */
internal data class MenuItem(
    @StringRes val title: Int,
    val onClick: () -> Unit
)

/**
 * Composable function that displays a menu item.
 *
 * The menu item is displayed as a [Surface] with a rounded corner shape, a background color,
 * and padding. The title of the menu item is displayed as a [Text] composable in the center
 * of the surface.
 *
 * @param menuItem The [MenuItem] data class containing the title and onClick action.
 */
@Composable
internal fun MenuItem(menuItem: MenuItem) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = menuItem.onClick,
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(stringResource(menuItem.title), maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}