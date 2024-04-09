package com.example.gitreposapp.di

import com.example.gitreposapp.repository.HomeRepository
import com.example.gitreposapp.retrofit.service.ApiEndPointService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        apiEndPointService: ApiEndPointService,
    ): HomeRepository {
        return HomeRepository(
            apiEndPointService
        )
    }
}