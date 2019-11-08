package vn.sunasterisk.realfootball.data.model

import com.google.gson.annotations.SerializedName

data class VideosItem(
    @SerializedName("embed")
    val embed: String,
    @SerializedName("title")
    val title: String
)
