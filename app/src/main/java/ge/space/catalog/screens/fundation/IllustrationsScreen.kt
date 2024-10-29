package ge.space.catalog.screens.fundation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import ge.space.catalog.main.ui.DesignSystemComponent
import ge.space.catalog.main.ui.shared.ComponentScreenContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun IllustrationsScreen(item: DesignSystemComponent) {
    ComponentScreenContent(title = item.titleRes) {
        //Todo: add content
    }
}