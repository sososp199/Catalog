package ge.space.catalog.main.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

internal data class MenuItem(
    val title: String,
    val icon: Any? = null,
    val onClick: () -> Unit
)

@Composable
internal fun MenuItem(menuItem: MenuItem) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = menuItem.onClick,
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProvideTextStyle(TextStyle.Default) {
                when (val icon = menuItem.icon) {
                    is Painter -> Icon(icon, contentDescription = null)
                    is ImageVector -> Icon(icon, contentDescription = null)
                    else -> {}
                }
                Spacer(Modifier.size(8.dp))
                Text(menuItem.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}