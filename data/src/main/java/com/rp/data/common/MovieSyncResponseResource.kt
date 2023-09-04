package com.rp.data.common

import com.rp.data.remote.model.MovieResultResponse

sealed class MovieSyncResponseResource {

    data class MovieSyncSuccess(val movies: List<MovieResultResponse>) : MovieSyncResponseResource()

    data class MovieSyncFailure(
        val description: String,
        val errorCode: Int
    ) : MovieSyncResponseResource()
}
