package ge.space.catalog

import androidx.compose.material.icons.rounded.Air
import androidx.compose.material.icons.rounded.Airlines
import androidx.compose.material.icons.rounded.BrowseGallery
import androidx.compose.material.icons.rounded.FormatSize
import androidx.compose.material.icons.rounded.SmartButton
import ge.space.catalog.main.ui.SPDesignSystemComponent
import ge.space.catalog.screens.controls.ButtonScreen
import ge.space.catalog.screens.fundation.ColorsScreen
import ge.space.catalog.screens.fundation.IconsScreen
import ge.space.catalog.screens.fundation.IllustrationsScreen
import ge.space.catalog.screens.fundation.TypographyScreen
import androidx.compose.material.icons.Icons.Rounded as MIcons

object SPDesignSystemComponents {
    internal val foundation = listOf(
        SPDesignSystemComponent("Colors", MIcons.Air) { ColorsScreen(it) },
        SPDesignSystemComponent("Icons", MIcons.Airlines) { IconsScreen(it) },
        SPDesignSystemComponent("Illustrations", MIcons.BrowseGallery) {
            IllustrationsScreen(it)
        },
        SPDesignSystemComponent("Typography", MIcons.FormatSize) { TypographyScreen(it) },
    )

    internal val controls = listOf(
        SPDesignSystemComponent("Button", MIcons.SmartButton) { ButtonScreen(it) },
    )
}