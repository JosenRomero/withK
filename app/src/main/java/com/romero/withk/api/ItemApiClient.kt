package com.romero.withk.api

import com.romero.withk.model.Item
import retrofit2.Response
import retrofit2.http.GET

interface ItemApiClient {

    @GET("v2/list?page=1&limit=5")
    suspend fun getAllItems(): Response<List<Item>>

}