package com.example.bankuishchallenge.core.di

import com.example.bankuishchallenge.mainscreen.domain.repository.ReposImplementation
import com.example.bankuishchallenge.mainscreen.data.repository.GetReposRepository
import com.example.bankuishchallenge.mainscreen.network.RepositoriesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
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
