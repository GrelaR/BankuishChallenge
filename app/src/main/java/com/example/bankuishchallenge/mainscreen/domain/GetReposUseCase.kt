package com.example.bankuishchallenge.mainscreen.domain

import com.example.bankuishchallenge.core.domain.Result
import com.example.bankuishchallenge.mainscreen.data.model.ReposListResponse
import com.example.bankuishchallenge.mainscreen.data.model.RepositoriesItemModel;
import com.example.bankuishchallenge.mainscreen.data.repository.GetReposRepository
import javax.inject.Inject

class GetReposUseCase @Inject constructor(private val repository:GetReposRepository) {

    suspend operator fun invoke(): Result<ReposListResponse> = repository.getRepos()

}
