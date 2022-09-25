package com.example.bankuishchallenge.mainscreen.network

import com.example.bankuishchallenge.mainscreen.data.model.ReposListResponse
import retrofit2.Response
import retrofit2.http.GET

interface  RepositoriesApiService {
    @GET("/search/repositories?q=kotlin&per_page=20&page=1")
    suspend fun getRepos(): Response<ReposListResponse>
}