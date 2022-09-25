package com.example.bankuishchallenge.core.di

import com.example.bankuishchallenge.mainscreen.data.model.repository.ReposImplementation
import com.example.bankuishchallenge.mainscreen.data.repository.GetReposRepository
import com.example.bankuishchallenge.mainscreen.network.RepositoriesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    val baseUrl = "https://api.github.com"

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRepositoriesApiService(retrofit: Retrofit): RepositoriesApiService {
        return retrofit.create(RepositoriesApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideGetReposRepository():GetReposRepository {
        return ReposImplementation(api = provideRepositoriesApiService(provideRetrofit()))
    }


}
