package vn.sunasterisk.realfootball.data.response

import com.google.gson.annotations.SerializedName
import vn.sunasterisk.realfootball.data.model.Highlight

data class HighlightsResponse(@SerializedName("highlight") val highlight: List<Highlight>)
