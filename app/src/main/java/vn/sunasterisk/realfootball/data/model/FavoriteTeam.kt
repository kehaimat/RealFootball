package com.rifqimfahmi.foorballapps.vo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_teams")
data class FavoriteTeam(
    @PrimaryKey
    val idTeam: String
)
