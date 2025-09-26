package com.gigcreator.filmplayer.feature.home.contract

import androidx.lifecycle.viewModelScope
import com.gigcreator.filmplayer.core.viewmodel.BaseViewModel
import com.gigcreator.filmplayer.domain.feature.home.interactor.HomeInteractor
import com.gigcreator.filmplayer.feature.home.HomeScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val homeInteractor: HomeInteractor
): BaseViewModel<HomeScreenContract.Event, HomeScreenContract.State, HomeScreenContract.Effect>() {

    private val _uiState: MutableStateFlow<HomeScreenUiState> =
        MutableStateFlow(HomeScreenUiState())

    internal val uiState: StateFlow<HomeScreenUiState>
        get() = _uiState.asStateFlow()

    override fun setInitialState(): HomeScreenContract.State = HomeScreenContract.State.Loading

    override fun handleEvent(event: HomeScreenContract.Event) {
        when(event) {
            is HomeScreenContract.Event.LoadData -> loadData()
        }
    }

    private fun loadData() {
        viewModelScope.launch(dispatcher) {
            collectUiState().fold(
                onSuccess = {
                    _uiState.emit(it)
                    setState(HomeScreenContract.State.Loaded)
                },
                onFailure = {
                    setState(HomeScreenContract.State.DataError)
                    it.message?.let { message ->
                        setEffect(HomeScreenContract.Effect.ShowToast(message))
                    }
                }
            )
        }
    }

    private suspend fun collectUiState(): Result<HomeScreenUiState> {
        return runCatching {
            val films = homeInteractor.getItems().getOrThrow()

            HomeScreenUiState(
                films = films
            )
        }
    }
}