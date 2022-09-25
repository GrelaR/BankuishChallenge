package com.example.bankuishchallenge.core.domain

sealed class IOError {
    object ServerError : IOError()
    object ClientError : IOError()
    object NetworkError : IOError()
}