package com.rp.data.remote.service

import com.rp.data.common.MovieSyncResponseResource
import com.rp.data.di.qualifiers.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

interface MovieApiService {
    suspend fun getPopularMovies(page: Int): MovieSyncResponseResource
    suspend fun getTopRatedMovies(page: Int): MovieSyncResponseResource
}

class MovieApiServiceImpl @Inject constructor(
    private val movieApi: MovieApi,
    @IODispatcher private val IODispatcher: CoroutineDispatcher
) : MovieApiService {

    override suspend fun getPopularMovies(page: Int): MovieSyncResponseResource =
        withContext(IODispatcher) {
            return@withContext try {
                val response = movieApi.getPopularMovies(page)
                if (response.isSuccessful) {
                    MovieSyncResponseResource.MovieSyncSuccess(
                        movies = response.body()?.results.orEmpty()
                    )
                } else {
                    MovieSyncResponseResource.MovieSyncFailure(
                        description = response.message().orEmpty(),
                        errorCode = response.code()
                    )
                }
            } catch (e: Exception) {
                MovieSyncResponseResource.MovieSyncFailure(
                    description = e.message.orEmpty(),
                    errorCode = 500
                )
            }
        }

    override suspend fun getTopRatedMovies(page: Int): MovieSyncResponseResource =
        withContext(IODispatcher) {
            return@withContext try {
                val response = movieApi.getTopRatedMovies(page)
                if (response.isSuccessful) {
                    MovieSyncResponseResource.MovieSyncSuccess(
                        movies = response.body()?.results.orEmpty()
                    )
                } else {
                    MovieSyncResponseResource.MovieSyncFailure(
                        description = response.message().orEmpty(),
                        errorCode = response.code()
                    )
                }
            } catch (e: Exception) {
                MovieSyncResponseResource.MovieSyncFailure(
                    description = e.message.orEmpty(),
                    errorCode = 500
                )
            }
        }
}
