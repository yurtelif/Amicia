package com.yrtelf.amicia.room.respository

import androidx.annotation.WorkerThread
import com.yrtelf.amicia.room.dao.ComicDao
import com.yrtelf.amicia.room.entity.Comic
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicRepository @Inject constructor(private val comicDao: ComicDao) {

    val allComics: Flow<List<Comic>> = comicDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(comic: Comic) {
        comicDao.insertAll(comic)
    }
}
