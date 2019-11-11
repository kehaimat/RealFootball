package com.rifqimfahmi.foorballapps.data.source.remote.json

import com.google.gson.annotations.SerializedName
import vn.sunasterisk.realfootball.data.model.Player

data class PlayersResponse(@SerializedName("player") val player: List<Player>)
