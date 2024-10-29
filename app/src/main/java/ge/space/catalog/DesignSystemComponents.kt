package ge.space.catalog

import ge.space.catalog.main.ui.GroupComponent
import ge.space.catalog.main.ui.SimpleComponent
import ge.space.catalog.screens.GroupComponentScreen
import ge.space.catalog.screens.controls.ButtonScreen
import ge.space.catalog.screens.fundation.ColorsScreen
import ge.space.catalog.screens.fundation.IconsScreen
import ge.space.catalog.screens.fundation.IllustrationsScreen
import ge.space.catalog.screens.fundation.TypographyScreen

internal object DesignSystemComponents {

    private fun foundationScreens() = listOf(
        SimpleComponent(R.string.component_title_colors) { ColorsScreen(it) },
        SimpleComponent(R.string.component_title_icons) { IconsScreen(it) },
        SimpleComponent(R.string.component_title_illustrations) { IllustrationsScreen(it) },
        SimpleComponent(R.string.component_title_typography) { TypographyScreen(it) },
    )

    private fun componentScreens() = listOf(
        SimpleComponent(R.string.component_title_button) { ButtonScreen(it) },
        GroupComponent(
            titleRes = R.string.component_title_list_sample,
            screen = { GroupComponentScreen(it) },
            innerComponents = listOf(
                SimpleComponent(R.string.component_title_component1) { ColorsScreen(it) },
                SimpleComponent(R.string.component_title_component2) { IconsScreen(it) }
            )
        )
    )

    internal val foundation = foundationScreens()
    internal val components = componentScreens()
}