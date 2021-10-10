package com.yrtelf.amicia.data.character

import com.yrtelf.amicia.api.RetrofitService
import com.yrtelf.amicia.api.RetrofitService.Companion.API_KEY
import com.yrtelf.amicia.api.RetrofitService.Companion.HASH
import com.yrtelf.amicia.api.RetrofitService.Companion.TS
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val retrofitService: RetrofitService) {

    suspend fun getCharacters() = retrofitService.getCharacters(TS, API_KEY, HASH, 0)
}
