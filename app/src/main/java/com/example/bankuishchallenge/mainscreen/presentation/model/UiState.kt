package com.example.bankuishchallenge.mainscreen.presentation.model

import com.example.bankuishchallenge.mainscreen.data.model.ReposListResponse

sealed class UiState {
    class UIShowLoading(val isShow: Boolean) : UiState()
    class RepositoriesList(val listOfRepos: ReposListResponse) : UiState()
}
