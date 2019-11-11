package vn.sunasterisk.realfootball.data.model

import com.google.gson.annotations.SerializedName

data class Side(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
