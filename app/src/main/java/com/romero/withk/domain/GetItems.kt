package com.romero.withk.domain

import com.romero.withk.model.Item
import com.romero.withk.repository.ItemRepository

class GetItems {

    private val repository = ItemRepository()

    suspend operator fun invoke(): List<Item> = repository.getAllItems()

}