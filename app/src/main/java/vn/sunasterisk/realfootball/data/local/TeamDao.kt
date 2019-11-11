package vn.sunasterisk.realfootball.data.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rifqimfahmi.foorballapps.vo.FavoriteTeam
import vn.sunasterisk.realfootball.data.model.Team

interface TeamDao {
    @Query("SELECT * FROM teams WHERE idLeague = :leagueId")
    fun getTeams(leagueId: String): LiveData<List<Team>>

    @Query("SELECT * FROM teams WHERE idTeam = :teamId")
    fun getTeam(teamId: String): LiveData<Team>

    @Query("DELETE FROM favorite_teams WHERE idTeam = :teamId")
    fun deleteFavoriteTeam(teamId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTeams(it: List<Team?>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToFavoriteTeam(favoriteTeam: FavoriteTeam)

    @Query("SELECT * FROM teams WHERE strTeam LIKE :query")
    fun searchTeam(query: String): LiveData<List<Team>>
}
