package com.example.bankuishchallenge.mainscreen.data.repository

import com.example.bankuishchallenge.core.domain.Result
import com.example.bankuishchallenge.mainscreen.data.model.ReposListResponse

interface GetReposRepository {
    suspend fun getRepos(
    ): Result<ReposListResponse>
}