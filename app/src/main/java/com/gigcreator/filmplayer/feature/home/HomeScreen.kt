package com.gigcreator.filmplayer.feature.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gigcreator.filmplayer.R
import com.gigcreator.filmplayer.domain.feature.home.model.Film
import com.gigcreator.filmplayer.feature.home.contract.HomeScreenContract
import com.gigcreator.filmplayer.feature.home.contract.HomeScreenViewModel
import com.gigcreator.filmplayer.feature.shared.components.home.CustomTab
import com.gigcreator.filmplayer.feature.shared.components.home.CustomTabIndicator
import com.gigcreator.filmplayer.feature.shared.components.home.FilmList
import com.gigcreator.filmplayer.feature.shared.components.home.SearchBar
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors
import com.gigcreator.filmplayer.feature.shared.theme.Typography

internal data class HomeScreenUiState(
    val films: List<Film> = listOf()
)

@Composable
fun HomeScreen(
    vm: HomeScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state by vm.state.collectAsStateWithLifecycle()
    val uiState by vm.uiState.collectAsState(HomeScreenUiState())

    LaunchedEffect(Unit) {
        vm.handleEvent(HomeScreenContract.Event.LoadData)
    }

    LaunchedEffect(vm.effect) {
        vm.effect.collect {
            when(it) {
                is HomeScreenContract.Effect.ShowToast -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    when(state) {
        is HomeScreenContract.State.Loading -> HomeScreenContent(uiState = uiState)
        is HomeScreenContract.State.Loaded -> HomeScreenContent(uiState = uiState)
        is HomeScreenContract.State.DataError -> {}
    }
}

@Composable
private fun HomeScreenContent(uiState: HomeScreenUiState) {
    val context = LocalContext.current
    var query by remember { mutableStateOf("") }

    val categories = remember { context.resources.getStringArray(R.array.categories_array) }
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.background(ApplicationColors.MainBackground).fillMaxSize()
    ) {
        Text(
            text = context.getString(R.string.main_header),
            style = Typography.latoMedium24,
            color = Color.White,
            modifier = Modifier.fillMaxWidth().padding(
                top = 36.dp, start = 24.dp, end = 24.dp
            )
        )
        SearchBar(
            query = query,
            onQueryChange = {
                query = it
            },
            placeholder = context.getString(R.string.sherlock_holmes),
            modifier = Modifier.fillMaxWidth().padding(
                top = 20.dp, start = 24.dp, end = 24.dp
            )
        )
        ScrollableTabRow(
            modifier = Modifier.fillMaxWidth().padding(
                top = 24.dp
            ),
            edgePadding = 24.dp,
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
            indicator = { tabPositions ->
                val currentTabPosition = tabPositions[selectedTabIndex]
                CustomTabIndicator(currentTabPosition)
            },
            divider = {}
        ) {
            categories.forEachIndexed { index, title ->
                CustomTab(
                    title = title,
                    onSelectTab = {
                        selectedTabIndex = index
                    },
                    currentIndex = index,
                    selectedTabIndex = selectedTabIndex,
                )
            }
        }

        FilmList(
            films = uiState.films,
            modifier = Modifier.fillMaxSize().padding(
                top = 16.dp, start = 14.dp, end = 14.dp
            )
        )
    }
}