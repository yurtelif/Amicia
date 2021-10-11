package com.yrtelf.amicia.data.comic

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yrtelf.amicia.api.RetrofitService

class ComicsPagingDataSource(private val service: RetrofitService) : PagingSource<Int, ComicResult>() {
    override fun getRefreshKey(state: PagingState<Int, ComicResult>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ComicResult> {
        val pageNumber = params.key ?: 0
        return try {
            val response = service.getComics(
                RetrofitService.TS,
                RetrofitService.API_KEY,
                RetrofitService.HASH, pageNumber
            )

            val data = response.data
            val results = data.results

            val nextKey =
                if (results.isEmpty()) {
                    null
                } else {
                    pageNumber + 20
                }

            LoadResult.Page(
                data = data.results.orEmpty(),
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
