package com.romero.withk.model

import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("id")val id: Int,
    @SerializedName("author")val author: String,
    @SerializedName("width")val width: Int,
    @SerializedName("height")val height: Int,
    @SerializedName("url")val url: String,
    @SerializedName("download_url")val image: String
)