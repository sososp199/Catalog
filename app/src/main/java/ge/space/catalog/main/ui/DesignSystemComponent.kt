package ge.space.catalog.main.ui

import androidx.compose.runtime.Composable

internal sealed interface DesignSystemComponent {
    val titleRes: Int
    val screen: @Composable (DesignSystemComponent) -> Unit
    val innerComponents: List<DesignSystemComponent> get() = emptyList()
}

internal data class SimpleComponent(
    override val titleRes: Int,
    override val screen: @Composable (DesignSystemComponent) -> Unit
) : DesignSystemComponent

internal data class GroupComponent(
    override val titleRes: Int,
    override val screen: @Composable (DesignSystemComponent) -> Unit,
    override val innerComponents: List<DesignSystemComponent>
) : DesignSystemComponent