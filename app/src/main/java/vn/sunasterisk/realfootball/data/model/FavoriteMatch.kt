package com.rifqimfahmi.foorballapps.vo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_matches")
data class FavoriteMatch(
    @PrimaryKey
    val idMatch: String
)
