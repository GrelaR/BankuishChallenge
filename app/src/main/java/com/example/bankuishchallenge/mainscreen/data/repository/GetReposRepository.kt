package com.example.bankuishchallenge.mainscreen.data.repository

import com.example.bankuishchallenge.mainscreen.data.model.ReposListResponse
import retrofit2.Response

interface GetReposRepository {
    suspend fun getRepos(
    ): Response<ReposListResponse>
}