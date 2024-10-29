package ge.space.catalog.main.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.sqrt

/**
 * A shape that represents a circular path with a given progress.
 *
 * The circle's center is animated from the origin towards the center of the shape's size
 * as the progress increases from 0f to 1f.
 *
 * @property progress The progress of the circular path, between 0f and 1f.
 * @property origin The origin point of the circle. Defaults to Offset(0f, 0f).
 */
class CirclePath(
    private val progress: Float,
    private val origin: Offset = Offset(0f, 0f),
) : Shape {
    /**
     * Creates the outline of the circular path.
     *
     * @param size The size of the shape.
     * @param layoutDirection The layout direction of the shape.
     * @param density The density of the screen.
     * @return The outline of the circular path.
     */
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        // Calculate the center of the circle based on the progress and origin.
        val center = Offset(
            x = size.center.x - ((size.center.x - origin.x) * (1f - progress)),
            y = size.center.y - ((size.center.y - origin.y) * (1f - progress)),
        )
        // Calculate the radius of the circle based on the progress and size.
        val radius = sqrt(
            size.height * size.height + size.width * size.width,
        ) * .5f * progress

        return Outline.Generic(
            Path().apply {
                addOval(
                    Rect(
                        center = center,
                        radius = radius,
                    ),
                )
            },
        )
    }
}