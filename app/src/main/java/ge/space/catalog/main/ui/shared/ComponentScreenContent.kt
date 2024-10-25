package ge.space.catalog.main.ui.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun ComponentScreenContent(
    title: String,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            ComponentScreenTopBar(title)
        },
    ) { contentPadding: PaddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(contentPadding),
        ) {
            content()
        }
    }
}