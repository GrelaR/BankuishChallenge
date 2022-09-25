package com.example.bankuishchallenge.core.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankuishchallenge.core.domain.IOError
import com.example.bankuishchallenge.core.presentation.data.CommonsErrorUiState
import kotlinx.coroutines.CoroutineExceptionHandler

open class BaseViewModel : ViewModel() {

    private val errorUiStateMutableLiveData = MutableLiveData<CommonsErrorUiState>()
    val errorUiState = errorUiStateMutableLiveData

    protected val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ ->
        errorUiStateMutableLiveData.postValue(CommonsErrorUiState(showGenericError = true))
    }

        protected fun manageError(error: IOError) {
            val uiState = when(error) {
                IOError.NetworkError -> CommonsErrorUiState(showConnectionError = true)
                else -> CommonsErrorUiState(showGenericError = true)
            }
        errorUiStateMutableLiveData.postValue(uiState)
        }
    }
