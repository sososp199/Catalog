package ge.space.catalog.main.ui

import androidx.compose.runtime.Composable

internal sealed interface SPDesignSystemComponent {
    val titleRes: Int
    val screen: @Composable (SPDesignSystemComponent) -> Unit
    val innerComponents: List<SPDesignSystemComponent> get() = emptyList()
}

internal data class SPSimpleComponent(
    override val titleRes: Int,
    override val screen: @Composable (SPDesignSystemComponent) -> Unit
) : SPDesignSystemComponent

internal data class SPCompositeComponent(
    override val titleRes: Int,
    override val screen: @Composable (SPDesignSystemComponent) -> Unit,
    override val innerComponents: List<SPDesignSystemComponent>
) : SPDesignSystemComponent