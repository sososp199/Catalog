package ge.space.catalog

import androidx.compose.material.icons.rounded.Air
import androidx.compose.material.icons.rounded.Airlines
import androidx.compose.material.icons.rounded.BrowseGallery
import androidx.compose.material.icons.rounded.FormatSize
import androidx.compose.material.icons.rounded.SmartButton
import ge.space.catalog.main.ui.SPDesignSystemComponent
import ge.space.catalog.screens.ComponentsListScreen
import ge.space.catalog.screens.controls.ButtonScreen
import ge.space.catalog.screens.fundation.ColorsScreen
import ge.space.catalog.screens.fundation.IconsScreen
import ge.space.catalog.screens.fundation.IllustrationsScreen
import ge.space.catalog.screens.fundation.TypographyScreen
import androidx.compose.material.icons.Icons.Rounded as MIcons

internal object SPDesignSystemComponents {
    internal val foundation = listOf(
        SPDesignSystemComponent(title = "Colors", icon = MIcons.Air) { ColorsScreen(it) },
        SPDesignSystemComponent(title = "Icons", icon = MIcons.Airlines) { IconsScreen(it) },
        SPDesignSystemComponent(title = "Illustrations", icon = MIcons.BrowseGallery) {
            IllustrationsScreen(it)
        },
        SPDesignSystemComponent(title = "Typography", icon = MIcons.FormatSize) {
            TypographyScreen(
                it
            )
        },
    )

    internal val controls = listOf(
        SPDesignSystemComponent(title = "Button", icon = MIcons.SmartButton) { ButtonScreen(it) },
        SPDesignSystemComponent(
            title = "List Sample", icon = MIcons.SmartButton,
            innerComponents = listOf(
                SPDesignSystemComponent(
                    title = "Component1",
                    icon = MIcons.Air
                ) { ColorsScreen(it) },
                SPDesignSystemComponent(title = "Component2", icon = MIcons.Airlines) {
                    IconsScreen(
                        it
                    )
                }
            )
        ) { ComponentsListScreen(it) },
    )
}