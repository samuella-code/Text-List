package com.hfad.text_list

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataItemDao {
    @Insert
    suspend fun insertAll(items: List<DataItem>)

    @Query("SELECT * FROM data_items ORDER BY id ASC")
    suspend fun getAll(): List<DataItem>
}