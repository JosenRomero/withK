package com.romero.withk.api

import com.romero.withk.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllItems(page: Int, limit: Int): List<Item> {

        // coroutine
        return withContext(Dispatchers.IO) {

            val response = retrofit.create(ItemApiClient::class.java).getAllItems(page, limit)

            // if response.body() is null then return emptyList
            response.body() ?: emptyList()

        }

    }


}