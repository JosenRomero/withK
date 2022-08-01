package com.romero.withk.api

import com.romero.withk.model.Item
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemApiClient {

    @GET("v2/list") // list?page=1&limit=5
    suspend fun getAllItems(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<Item>>

}