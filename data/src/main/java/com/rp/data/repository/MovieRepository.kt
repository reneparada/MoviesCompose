package com.rp.data.repository

interface MovieRepository {

    suspend fun getTopRatedMovies()
}