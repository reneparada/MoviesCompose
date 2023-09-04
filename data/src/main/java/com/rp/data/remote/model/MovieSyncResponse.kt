package com.rp.data.remote.model

data class MovieSyncResponse(
    val page: Int,
    val results: List<MovieResultResponse>,
    val total_pages: Int,
    val total_results: Int
)
