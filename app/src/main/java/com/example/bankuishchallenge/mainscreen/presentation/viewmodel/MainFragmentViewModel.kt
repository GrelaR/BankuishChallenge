package com.example.bankuishchallenge.mainscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.bankuishchallenge.core.domain.Result
import com.example.bankuishchallenge.core.presentation.BaseViewModel
import com.example.bankuishchallenge.mainscreen.domain.GetReposUseCase
import com.example.bankuishchallenge.mainscreen.presentation.model.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
): BaseViewModel() {

    private val _getReposResult = MutableLiveData<UiState>()
    val reposResult: LiveData<UiState> = _getReposResult

    fun initGetRepos() {
        viewModelScope.launch {
            _getReposResult.postValue(UiState.UIShowLoading(true))
            val result = getReposUseCase.invoke()
            if(result.isSuccessful) {
                _getReposResult.postValue(UiState.UIShowLoading(false))
                result.body().let {
                    it?.let {
                        _getReposResult.postValue(UiState.RepositoriesList(it))
                    }
                }
            } else {

            }
//            when (
//                val result = getReposUseCase.invoke()
//            ) {
//                is Result.Success -> {
//                    _getReposResult.postValue(UiState.UIShowLoading(false))
//                }
//                is Result.Error -> {
//                    manageError(result.error)
//                }
//            }

        }
    }

}