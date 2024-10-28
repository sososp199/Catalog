package ge.space.catalog.main.ui

import androidx.compose.runtime.Composable

internal data class SPDesignSystemComponent(
    val title: String,
    val innerComponents: List<SPDesignSystemComponent> = emptyList(),
    val screen: @Composable (SPDesignSystemComponent) -> Unit
)