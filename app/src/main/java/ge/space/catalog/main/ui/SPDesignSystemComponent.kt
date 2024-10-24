package ge.space.catalog.main.ui

import androidx.compose.runtime.Composable

data class SPDesignSystemComponent(
    val title: String,
    val icon: Any? = null,
    val screen: @Composable (onNavigateUp: () -> Unit) -> Unit
)