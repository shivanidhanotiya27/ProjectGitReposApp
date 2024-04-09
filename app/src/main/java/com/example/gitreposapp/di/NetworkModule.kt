package com.example.gitreposapp.di

import com.example.gitreposapp.retrofit.service.ApiEndPointService
import com.example.gitreposapp.utility.RestAPIs
import com.hadiyarajesh.flower_retrofit.FlowerCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideApiEndPointService(retrofit: Retrofit): ApiEndPointService {
        return retrofit.create(ApiEndPointService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        moshiConvertorFactory: MoshiConverterFactory,
        flowerCallConverterFactory: FlowerCallAdapterFactory

    ): Retrofit {
        return Retrofit.Builder().baseUrl(RestAPIs.BASE_URL)
            .addConverterFactory(moshiConvertorFactory)
            .addCallAdapterFactory(flowerCallConverterFactory)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshiConvertorFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideFlowerCallConvertorFactory(): FlowerCallAdapterFactory {
        return FlowerCallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideSecureHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .retryOnConnectionFailure(false)
            .addInterceptor(loggingInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}