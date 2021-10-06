package com.yrtelf.amicia.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yrtelf.amicia.data.character.CharacterData
import com.yrtelf.amicia.data.character.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(val characterRepository: CharacterRepository) : ViewModel() {

    val characterList = MutableLiveData<CharacterData>()
    var job: Job? = null
    val errorMessage = MutableLiveData<String>()
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getCharacters() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = characterRepository.getCharacters()
            withContext(Dispatchers.Main) {
                if (response.code == 200) {
                    characterList.postValue(response.data)
                    Log.d("TAGa", "getCharacters: ")
                } else {
                    Log.d("TAGa", "error: ")

                    onError("Error :  ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
