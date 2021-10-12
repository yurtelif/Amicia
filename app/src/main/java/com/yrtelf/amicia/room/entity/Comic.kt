package com.yrtelf.amicia.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comics")
data class Comic(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "api_id") val apiId: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "description") val description: String?
)
