package com.hfad.text_list

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "data_items")
data class DataItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String
)