package ge.space.catalog

import ge.space.catalog.main.ui.SPDesignSystemComponent
import ge.space.catalog.screens.ComponentsListScreen
import ge.space.catalog.screens.controls.ButtonScreen
import ge.space.catalog.screens.fundation.ColorsScreen
import ge.space.catalog.screens.fundation.IconsScreen
import ge.space.catalog.screens.fundation.IllustrationsScreen
import ge.space.catalog.screens.fundation.TypographyScreen

internal object SPDesignSystemComponents {
    internal val foundation = listOf(
        SPDesignSystemComponent(title = "Colors") { ColorsScreen(it) },
        SPDesignSystemComponent(title = "Icons") { IconsScreen(it) },
        SPDesignSystemComponent(title = "Illustrations") { IllustrationsScreen(it) },
        SPDesignSystemComponent(title = "Typography") { TypographyScreen(it) },
    )

    internal val controls = listOf(
        SPDesignSystemComponent(title = "Button") { ButtonScreen(it) },
        SPDesignSystemComponent(
            title = "List Sample",
            innerComponents = listOf(
                SPDesignSystemComponent(
                    title = "Component1",
                ) { ColorsScreen(it) },
                SPDesignSystemComponent(title = "Component2") { IconsScreen(it) }
            )
        ) { ComponentsListScreen(it) },
    )
}