package vn.sunasterisk.realfootball.data.model

import com.google.gson.annotations.SerializedName

data class Competition(
	@SerializedName("name")
	val name: String,
	@SerializedName("id")
	val id: Int,
	@SerializedName("url")
	val url: String
)
