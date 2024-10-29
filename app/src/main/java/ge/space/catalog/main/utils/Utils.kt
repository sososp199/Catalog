package ge.space.catalog.main.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import ge.space.catalog.main.ui.DesignSystemComponent

/**
 * Returns the sum of this [PaddingValues] and [other].
 */
operator fun PaddingValues.plus(other: PaddingValues): PaddingValues =
    UnionPaddingValues(this, other)

/**
 * A [PaddingValues] implementation that represents the union of two [PaddingValues] instances.
 *
 * @property a The first [PaddingValues] instance.
 * @property b The second [PaddingValues] instance.
 */
private class UnionPaddingValues(
    private val a: PaddingValues,
    private val b: PaddingValues,
) : PaddingValues {
    /**
     * Calculates the bottom padding by adding the bottom padding of [a] and [b].
     */
    override fun calculateBottomPadding(): Dp =
        a.calculateBottomPadding() + b.calculateBottomPadding()

    /**
     * Calculates the left padding by adding the left padding of [a] and [b]
     * for the given [layoutDirection].
     */
    override fun calculateLeftPadding(layoutDirection: LayoutDirection): Dp =
        a.calculateLeftPadding(layoutDirection) + b.calculateLeftPadding(layoutDirection)

    /**
     * Calculates the right padding by adding the right padding of [a] and [b]
     * for the given [layoutDirection].
     */
    override fun calculateRightPadding(layoutDirection: LayoutDirection): Dp =
        a.calculateRightPadding(layoutDirection) + b.calculateRightPadding(layoutDirection)

    /**
     * Calculates the top padding by adding the top padding of [a] and [b].
     */
    override fun calculateTopPadding(): Dp =
        a.calculateTopPadding() + b.calculateTopPadding()
}

/**
 * Flattens a list of [DesignSystemComponent]s by including all inner components.
 *
 * This function recursively iterates through the list and adds each component and its
 * inner components to a new list.
 *
 * @return A new list containing all components and their inner components.
 */
internal fun List<DesignSystemComponent>.flatten(): List<DesignSystemComponent> {
    val result = mutableListOf<DesignSystemComponent>()
    forEach {
        result.add(it)
        result.addAll(it.innerComponents.flatten())
    }
    return result
}