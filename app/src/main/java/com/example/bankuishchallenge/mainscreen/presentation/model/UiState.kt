package com.example.bankuishchallenge.mainscreen.presentation.model

sealed class UiState {
    class UIShowLoading(val isShow: Boolean) : UiState()
    class RepositoriesList(val listOfRepos: ReposListResponse) : UiState()
}
