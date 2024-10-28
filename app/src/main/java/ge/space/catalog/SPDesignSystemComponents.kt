package ge.space.catalog

import ge.space.catalog.main.ui.SPCompositeComponent
import ge.space.catalog.main.ui.SPSimpleComponent
import ge.space.catalog.screens.ComponentsListScreen
import ge.space.catalog.screens.controls.ButtonScreen
import ge.space.catalog.screens.fundation.ColorsScreen
import ge.space.catalog.screens.fundation.IconsScreen
import ge.space.catalog.screens.fundation.IllustrationsScreen
import ge.space.catalog.screens.fundation.TypographyScreen

internal object SPDesignSystemComponents {

    private fun foundationScreens() = listOf(
        SPSimpleComponent(R.string.component_title_colors) { ColorsScreen(it) },
        SPSimpleComponent(R.string.component_title_icons) { IconsScreen(it) },
        SPSimpleComponent(R.string.component_title_illustrations) { IllustrationsScreen(it) },
        SPSimpleComponent(R.string.component_title_typography) { TypographyScreen(it) },
    )

    private fun componentScreens() = listOf(
        SPSimpleComponent(R.string.component_title_button) { ButtonScreen(it) },
        SPCompositeComponent(
            titleRes = R.string.component_title_list_sample,
            screen = { ComponentsListScreen(it) },
            innerComponents = listOf(
                SPSimpleComponent(R.string.component_title_component1) { ColorsScreen(it) },
                SPSimpleComponent(R.string.component_title_component2) { IconsScreen(it) }
            )
        )
    )

    internal val foundation = foundationScreens()
    internal val components = componentScreens()
}