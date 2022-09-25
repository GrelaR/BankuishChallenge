package com.example.bankuishchallenge.mainscreen.domain

import com.example.bankuishchallenge.mainscreen.data.model.ReposListResponse
import com.example.bankuishchallenge.mainscreen.data.repository.GetReposRepository
import retrofit2.Response
import javax.inject.Inject

class GetReposUseCase @Inject constructor(private val repository:GetReposRepository) {

    suspend operator fun invoke(): Response<ReposListResponse> = repository.getRepos()

}
