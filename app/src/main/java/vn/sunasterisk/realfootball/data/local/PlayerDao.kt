package vn.sunasterisk.realfootball.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.rifqimfahmi.foorballapps.vo.FavoriteMatch
import com.rifqimfahmi.foorballapps.vo.FavoriteTeam
import vn.sunasterisk.realfootball.data.model.Match
import vn.sunasterisk.realfootball.data.model.Player
import vn.sunasterisk.realfootball.data.model.Team

@Dao
interface PlayerDao {
    @Query("SELECT * FROM players WHERE idTeam = :teamId")
    fun getPlayers(teamId: String): LiveData<List<Player>>

    @Query("SELECT * FROM players WHERE idPlayer = :playerId")
    fun getPlayer(playerId: String): LiveData<Player>

    @Insert(onConflict = REPLACE)
    fun savePlayers(players: List<Player?>)

    @Query("SELECT * FROM players WHERE strPlayer LIKE :query")
    fun searchPlayer(query: String): LiveData<List<Player>>
}
