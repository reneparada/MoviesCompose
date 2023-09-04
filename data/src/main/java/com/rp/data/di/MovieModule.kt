package com.rp.data.di

import com.rp.data.remote.service.MovieApi
import com.rp.data.remote.service.MovieApiService
import com.rp.data.remote.service.MovieApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideMovieApi(
        retrofit: Retrofit
    ): MovieApi =
        retrofit.create(MovieApi::class.java)

    @Provides
    @Singleton
    fun provideMovieApiService(impl: MovieApiServiceImpl): MovieApiService = impl
}
