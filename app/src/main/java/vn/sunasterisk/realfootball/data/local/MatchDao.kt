package vn.sunasterisk.realfootball.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rifqimfahmi.foorballapps.vo.FavoriteMatch
import vn.sunasterisk.realfootball.data.model.Match

@Dao
interface MatchDao {
    @Query("SELECT * FROM matches WHERE idEvent = :matchId")
    fun getMatchDetail(matchId: String): LiveData<Match>

    @Query("DELETE FROM favorite_matches WHERE idMatch = :matchId")
    fun deleteFavoriteMatch(matchId: String)

    @Query("SELECT * FROM matches INNER JOIN favorite_matches ON favorite_matches.idMatch = idEvent ORDER BY dateEvent DESC")
    fun getFavoriteMatches(): LiveData<List<Match>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMatches(matches: List<Match?>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToFavoriteMatch(favMatch: FavoriteMatch)

    @Query("SELECT * FROM matches WHERE strEvent LIKE :query ORDER BY dateEvent DESC")
    fun searchMatch(query: String): LiveData<List<Match>>

    @Query("DELETE FROM matches WHERE matchType = :type AND idLeague = :idLeague")
    suspend fun deleteMatches(idLeague: String?, type: String)

    @Query("SELECT * FROM matches WHERE idLeague = :idLeague AND matchType = :type ORDER BY dateEvent DESC LIMIT 30")
    fun getMatches(idLeague: String?, type: String): LiveData<List<Match>>
}
