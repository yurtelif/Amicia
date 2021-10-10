package com.yrtelf.amicia.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yrtelf.amicia.api.RetrofitService
import com.yrtelf.amicia.data.character.CharacterResult
import com.yrtelf.amicia.data.character.CharactersPagingDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(val service: RetrofitService) : ViewModel() {

    val characters: Flow<PagingData<CharacterResult>> =
        Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = { CharactersPagingDataSource(service) }
        ).flow.cachedIn(viewModelScope)
}
