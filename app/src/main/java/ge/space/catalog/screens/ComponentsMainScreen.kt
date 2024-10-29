package ge.space.catalog.screens

import androidx.activity.compose.ReportDrawn
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toOffset
import ge.space.catalog.R
import ge.space.catalog.SPDesignSystemComponents.components
import ge.space.catalog.SPDesignSystemComponents.foundation
import ge.space.catalog.main.ui.shared.MenuItem
import ge.space.catalog.main.utils.flatten
import ge.space.catalog.main.utils.plus
import kotlinx.coroutines.android.awaitFrame

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    onNavigate: (String) -> Unit,
    onThemeToggle: (Offset) -> Unit,
) {
    var searchQuery by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(
            TextFieldValue("")
        )
    }
    var isSearchExpanded by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val searchFocusRequester = remember { FocusRequester() }

    // Flatten the component lists
    val flattenedComponents = remember { (foundation + components).flatten() }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    if (isSearchExpanded) {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(searchFocusRequester),
                            placeholder = { Text(stringResource(R.string.search_hint)) },
                            singleLine = true,
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                                unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                cursorColor = MaterialTheme.colorScheme.primary,
                                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                                unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            trailingIcon = {
                                IconButton(onClick = {
                                    searchQuery = TextFieldValue("")
                                    isSearchExpanded = false
                                    focusManager.clearFocus()
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close Search"
                                    )
                                }
                            }
                        )

                        LaunchedEffect(isSearchExpanded) {
                            if (isSearchExpanded) {
                                awaitFrame()
                                searchFocusRequester.requestFocus()
                            }
                        }
                    } else {
                        Text(stringResource(R.string.app_name))
                    }
                },
                actions = {
                    if (!isSearchExpanded) {
                        IconButton(onClick = { isSearchExpanded = true }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        }
                    }
                    var offset by remember { mutableStateOf(Offset(0f, 0f)) }
                    IconButton(
                        modifier = Modifier.onGloballyPositioned {
                            offset = it.positionInWindow() + it.size.center.toOffset()
                        },
                        onClick = { onThemeToggle(offset) },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dark_theme),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { contentPadding ->
        // Filter the flattened list if there's a search query
        val filteredComponents = if (searchQuery.text.isNotEmpty()) {
            flattenedComponents.filter {
                stringResource(it.titleRes).contains(searchQuery.text, ignoreCase = true)
            }
        } else {
            null  // Keep null to show default content when no search query
        }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = contentPadding.plus(PaddingValues(16.dp)),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (filteredComponents != null) {
                // Display search results if filtered list is not null
                items(filteredComponents) { item ->
                    MenuItem(
                        MenuItem(
                            item.titleRes,
                            onClick = { onNavigate(item.titleRes.toString()) })
                    )
                }
            } else {
                // Display default content if there's no search query
                cardItems(R.string.category_title_foundation, foundation.map { item ->
                    MenuItem(item.titleRes, onClick = {
                        onNavigate(item.titleRes.toString())
                    })
                })
                cardItems(R.string.category_title_components, components.map { item ->
                    MenuItem(item.titleRes, onClick = { onNavigate(item.titleRes.toString()) })
                })
            }
        }
    }

    ReportDrawn()
}


private fun LazyGridScope.cardItems(
    @StringRes title: Int,
    items: List<MenuItem>,
) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        Text(
            text = stringResource(title),
            modifier = Modifier.padding(vertical = 4.dp),
        )
    }
    items(items) { item -> MenuItem(item) }
}
