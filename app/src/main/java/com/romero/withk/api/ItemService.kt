package com.romero.withk.api

import com.romero.withk.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllItems(): List<Item> {

        // coroutine
        return withContext(Dispatchers.IO) {

            val response = retrofit.create(ItemApiClient::class.java).getAllItems()

            // if response.body() is null then return emptyList
            response.body() ?: emptyList()

        }

    }


}