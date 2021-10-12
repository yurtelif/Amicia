package com.yrtelf.amicia.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yrtelf.amicia.room.entity.Comic
import kotlinx.coroutines.flow.Flow

@Dao
interface ComicDao {

    @Insert
    fun insertAll(vararg comic: Comic)

    @Delete
    fun delete(comic: Comic)

    @Query("SELECT * FROM comics")
    fun getAll(): Flow<List<Comic>>
}
