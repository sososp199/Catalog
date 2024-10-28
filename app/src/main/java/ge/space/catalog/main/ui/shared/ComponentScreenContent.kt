package ge.space.catalog.main.ui.shared

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
internal fun ComponentScreenContent(
    @StringRes title: Int,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            ComponentScreenTopBar(stringResource(title))
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