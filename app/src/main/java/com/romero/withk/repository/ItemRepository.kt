package com.romero.withk.repository

import com.romero.withk.api.ItemService
import com.romero.withk.model.Item

class ItemRepository {

    private val api = ItemService()

    suspend fun getAllItems(page: Int, limit: Int): List<Item> {

        return api.getAllItems(page, limit)

    }
}