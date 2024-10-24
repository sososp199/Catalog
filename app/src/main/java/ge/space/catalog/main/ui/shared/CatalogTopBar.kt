package ge.space.catalog.main.ui.shared

import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons.Rounded as MIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CatalogTopBar(title: String, onNavigateUp: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = { onNavigateUp() },
            ) {
                Icon(MIcons.ArrowBack, contentDescription = null)
            }
        }
    )
}