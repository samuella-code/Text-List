package com.hfad.text_list


class DataRepository(private val dao: DataItemDao) {
    suspend fun getAllDataItems(): List<DataItem> = dao.getAll()
    suspend fun insertDataItems(items: List<DataItem>) = dao.insertAll(items)
}