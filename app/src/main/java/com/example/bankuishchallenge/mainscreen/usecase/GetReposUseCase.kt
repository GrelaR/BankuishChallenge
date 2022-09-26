package com.example.bankuishchallenge.mainscreen.usecase

import com.example.bankuishchallenge.mainscreen.presentation.model.ReposListResponse
import com.example.bankuishchallenge.mainscreen.data.repository.GetReposRepository
import retrofit2.Response
import javax.inject.Inject

class GetReposUseCase @Inject constructor(private val repository:GetReposRepository) {

    suspend operator fun invoke(): Response<ReposListResponse> = repository.getRepos()

}
