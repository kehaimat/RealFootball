package vn.sunasterisk.realfootball.data.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rifqimfahmi.foorballapps.vo.FavoriteMatch
import vn.sunasterisk.realfootball.data.model.Match

interface MatchDao {
    @Query("SELECT * FROM matches WHERE idEvent = :matchId")
    fun getMatchDetail(matchId: String): LiveData<Match>

    @Query("DELETE FROM favorite_matches WHERE idMatch = :matchId")
    fun deleteFavoriteMatch(matchId: String)

    @Query("SELECT * FROM matches INNER JOIN favorite_matches ON favorite_matches.idMatch = idEvent ORDER BY dateEvent DESC")
    fun getFavoriteMatches(): LiveData<List<Match>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMatches(matches: List<Match?>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToFavoriteMatch(favMatch: FavoriteMatch)

    @Query("SELECT * FROM matches WHERE strEvent LIKE :query ORDER BY dateEvent DESC")
    fun searchMatch(query: String): LiveData<List<Match>>
}
