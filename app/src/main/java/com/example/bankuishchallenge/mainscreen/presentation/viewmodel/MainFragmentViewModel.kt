package com.example.bankuishchallenge.mainscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankuishchallenge.mainscreen.usecase.GetReposUseCase
import com.example.bankuishchallenge.mainscreen.presentation.model.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
): ViewModel() {

    private val _getReposResult = MutableLiveData<UiState>()
    val reposResult: LiveData<UiState> = _getReposResult

    fun initGetRepos() {
        viewModelScope.launch {
            _getReposResult.postValue(UiState.UIShowLoading(true))
            val result = getReposUseCase.invoke()
            if(result.isSuccessful) {
                result.body().let {
                    it?.let {
                        _getReposResult.postValue(UiState.RepositoriesList(it))
                    }
                }
            }
        }
    }

}