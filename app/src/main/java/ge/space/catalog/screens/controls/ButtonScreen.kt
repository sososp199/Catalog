package ge.space.catalog.screens.controls

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import ge.space.catalog.main.ui.DesignSystemComponent
import ge.space.catalog.main.ui.shared.ComponentScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ButtonScreen(item: DesignSystemComponent) {
    ComponentScreenContent(title = item.titleRes) {
        //Todo: add content
    }
}