package com.gigcreator.filmplayer.feature.home.contract

import com.gigcreator.filmplayer.core.viewmodel.ViewEffect
import com.gigcreator.filmplayer.core.viewmodel.ViewEvent
import com.gigcreator.filmplayer.core.viewmodel.ViewState


object HomeScreenContract {

    sealed interface Event : ViewEvent {
        data object LoadData : Event
    }

    sealed interface State : ViewState {
        data object Loading : State
        data object Loaded : State
        data object DataError : State
    }

    sealed interface Effect : ViewEffect {
        data class ShowToast(val message: String) : Effect
    }
}