package com.example.bankuishchallenge.mainscreen.data.model.repository

import com.example.bankuishchallenge.mainscreen.data.model.ReposListResponse
import com.example.bankuishchallenge.mainscreen.data.repository.GetReposRepository
import com.example.bankuishchallenge.mainscreen.network.RepositoriesApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class ReposImplementation @Inject constructor(
    private val api: RepositoriesApiService
) : GetReposRepository {
    override suspend fun getRepos(): Response<ReposListResponse> {

        return withContext(Dispatchers.IO) {
            val response = api.getRepos()
            response
        }
    }
}