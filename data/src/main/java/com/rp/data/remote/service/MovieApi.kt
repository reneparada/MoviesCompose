package com.rp.data.remote.service

import com.rp.data.remote.model.MovieSyncResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int = 1): Response<MovieSyncResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("page") page: Int = 1): Response<MovieSyncResponse>

    @GET("search/movie")
    fun findMovies(@Query("query") query: String = ""): Response<MovieSyncResponse>
}
