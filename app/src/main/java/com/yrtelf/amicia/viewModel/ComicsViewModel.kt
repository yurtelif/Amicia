package com.yrtelf.amicia.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yrtelf.amicia.api.RetrofitService
import com.yrtelf.amicia.data.comic.ComicResult
import com.yrtelf.amicia.data.comic.ComicsPagingDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(val service: RetrofitService) : ViewModel() {

    val comics: Flow<PagingData<ComicResult>> =
        Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = { ComicsPagingDataSource(service) }
        ).flow.cachedIn(viewModelScope)
}
