package com.example.bankuishchallenge.mainscreen.network

import com.example.bankuishchallenge.core.domain.Result
import com.example.bankuishchallenge.mainscreen.data.model.ReposListResponse
import com.example.bankuishchallenge.mainscreen.data.model.RepositoriesItemModel
import retrofit2.http.GET

interface  RepositoriesApiService {
    @GET("/search/repositories?q=kotlin&per_page=20&page=1")
    suspend fun getRepos(): Result<ReposListResponse>
}