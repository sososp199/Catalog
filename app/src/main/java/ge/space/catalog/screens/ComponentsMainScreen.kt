package ge.space.catalog.screens

import androidx.activity.compose.ReportDrawn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.rounded.BrightnessMedium
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toOffset
import ge.space.catalog.SPDesignSystemComponents.controls
import ge.space.catalog.SPDesignSystemComponents.foundation
import ge.space.catalog.main.ui.shared.MenuItem
import ge.space.catalog.main.utils.plus
import androidx.compose.material.icons.Icons.Rounded as MIcons


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    onNavigate: (String) -> Unit,
    onThemeToggle: (Offset) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Catalog") },
                actions = {
                    var offset by remember { mutableStateOf(Offset(0f, 0f)) }
                    IconButton(
                        modifier = Modifier.onGloballyPositioned {
                            offset = it.positionInWindow() + it.size.center.toOffset()
                        },
                        onClick = { onThemeToggle(offset) },
                    ) {
                        Icon(MIcons.BrightnessMedium, contentDescription = null)
                    }
                },
            )
        },
    ) { contentPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = contentPadding.plus(PaddingValues(16.dp)),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            cardItems("Foundation", foundation.map { item ->
                MenuItem(item.title, item.icon, onClick = {
                    onNavigate(item.title)
                })
            })
            cardItems("Controls", controls.map { item ->
                MenuItem(item.title, item.icon, onClick = { onNavigate(item.title) })
            })
        }
    }

    ReportDrawn()
}

private fun LazyGridScope.cardItems(
    title: String,
    items: List<MenuItem>,
) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        Text(
            text = title,
            modifier = Modifier.padding(vertical = 4.dp),
        )
    }
    items(items) { item -> MenuItem(item) }
}
