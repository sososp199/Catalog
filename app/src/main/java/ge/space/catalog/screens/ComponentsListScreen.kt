package ge.space.catalog.screens

import androidx.activity.compose.ReportDrawn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ge.space.catalog.main.navigation.LocalNavController
import ge.space.catalog.main.ui.SPDesignSystemComponent
import ge.space.catalog.main.ui.shared.ComponentScreenTopBar
import ge.space.catalog.main.ui.shared.MenuItem
import ge.space.catalog.main.utils.plus


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ComponentsListScreen(
    component: SPDesignSystemComponent
) {
    val navigator = LocalNavController.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ComponentScreenTopBar(stringResource(component.titleRes))
        },
    ) { contentPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = contentPadding.plus(PaddingValues(16.dp)),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            component.innerComponents.map { item ->
                MenuItem(item.titleRes, onClick = {
                    navigator.navigate(item.titleRes.toString())
                })
            }.let { items(it) { item -> MenuItem(item) } }
        }
    }

    ReportDrawn()
}
