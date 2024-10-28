package ge.space.catalog.screens

import androidx.activity.compose.ReportDrawn
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toOffset
import ge.space.catalog.SPDesignSystemComponents.components
import ge.space.catalog.SPDesignSystemComponents.foundation
import ge.space.catalog.main.ui.shared.MenuItem
import ge.space.catalog.main.utils.plus
import ge.space.catalog.R


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
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dark_theme),
                            contentDescription = null
                        )
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
            cardItems(R.string.category_title_foundation, foundation.map { item ->
                MenuItem(item.titleRes, onClick = {
                    onNavigate(item.titleRes.toString())
                })
            })
            cardItems(R.string.category_title_components, components.map { item ->
                MenuItem(item.titleRes, onClick = { onNavigate(item.titleRes.toString()) })
            })
        }
    }

    ReportDrawn()
}

private fun LazyGridScope.cardItems(
    @StringRes title: Int,
    items: List<MenuItem>,
) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        Text(
            text = stringResource(title),
            modifier = Modifier.padding(vertical = 4.dp),
        )
    }
    items(items) { item -> MenuItem(item) }
}
