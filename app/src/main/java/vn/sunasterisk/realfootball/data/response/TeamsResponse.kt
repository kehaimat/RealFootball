package com.rifqimfahmi.foorballapps.data.source.remote.json

import com.google.gson.annotations.SerializedName
import vn.sunasterisk.realfootball.data.model.Team

data class TeamsResponse (@SerializedName( "teams") val teams: List<Team>)
