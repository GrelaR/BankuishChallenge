package com.example.bankuishchallenge.mainscreen.presentation.model

import androidx.annotation.Keep

@Keep
data class ReposListResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<RepositoriesItemModel>
)