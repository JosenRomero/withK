package com.romero.withk.domain

import com.romero.withk.model.Item
import com.romero.withk.repository.ItemRepository

class GetItems {

    private val repository = ItemRepository()

    suspend operator fun invoke(page: Int, limit: Int): List<Item> = repository.getAllItems(page, limit)

}