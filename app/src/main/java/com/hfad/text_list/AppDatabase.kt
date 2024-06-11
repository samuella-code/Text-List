package com.hfad.text_list

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataItemDao(): DataItemDao
}