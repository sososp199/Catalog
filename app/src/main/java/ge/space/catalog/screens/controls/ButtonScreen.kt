package ge.space.catalog.screens.controls

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import ge.space.catalog.main.ui.SPDesignSystemComponent
import ge.space.catalog.main.ui.shared.ComponentScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ButtonScreen(item: SPDesignSystemComponent) {
    ComponentScreenContent(title = item.titleRes) {
        //Todo: add content
    }
}