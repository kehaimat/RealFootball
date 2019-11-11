package vn.sunasterisk.realfootball.data.model

import com.google.gson.annotations.SerializedName

data class Highlight(
    @SerializedName("date")
    val date: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("videos")
    val videos: List<VideosItem>,
    @SerializedName("embed")
    val embed: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("side1")
    val side1: Side,
    @SerializedName("side2")
    val side2: Side
)
