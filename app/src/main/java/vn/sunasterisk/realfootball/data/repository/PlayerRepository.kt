package vn.sunasterisk.realfootball.data.repository

import androidx.lifecycle.LiveData
import com.rifqimfahmi.foorballapps.data.source.remote.json.PlayersResponse
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.base.ContextProviders
import vn.sunasterisk.realfootball.base.NetworkBoundResource
import vn.sunasterisk.realfootball.data.local.PlayerDao
import vn.sunasterisk.realfootball.data.model.Player
import vn.sunasterisk.realfootball.di.FootballService

class PlayerRepository(
    val coroutines: ContextProviders,
    private val footballService: FootballService,
    private val playerDao: PlayerDao
) {
    fun searchTeam(query: String): LiveData<BaseResponse<List<Player>>> =
        object : NetworkBoundResource<List<Player>, PlayersResponse>(coroutines) {
            override suspend fun saveCallResult(item: PlayersResponse) {
                playerDao.savePlayers(item.player)
            }

            override fun createCall(): LiveData<BaseResponse<PlayersResponse>> =
                footballService.searchPlayer(query)

            override fun shouldFetch(data: List<Player>?): Boolean = true

            override suspend fun loadFromDatabase(): LiveData<List<Player>> =
                playerDao.searchPlayer("%$query%")
        }.asLiveData()
}
