package ge.space.catalog.screens.fundation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.space.catalog.main.ui.shared.CatalogTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun IconsScreen(onNavigateUp: () -> Unit) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            CatalogTopBar("Icons", onNavigateUp)
        },
    ) { contentPadding: PaddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(contentPadding),
        ) {
            //Todo: add content
        }
    }
}