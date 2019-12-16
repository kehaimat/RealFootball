package vn.sunasterisk.realfootball.data.repository

import androidx.lifecycle.LiveData
import com.rifqimfahmi.foorballapps.data.source.remote.json.TeamsResponse
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.base.ContextProviders
import vn.sunasterisk.realfootball.base.NetworkBoundResource
import vn.sunasterisk.realfootball.data.local.TeamDao
import vn.sunasterisk.realfootball.data.model.Team
import vn.sunasterisk.realfootball.di.FootballService

class TeamRepository(
    val coroutines: ContextProviders,
    private val footballService: FootballService,
    private val teamDao: TeamDao
) {
    fun getTeam(teamId: String): LiveData<BaseResponse<Team>> =
        object : NetworkBoundResource<Team, TeamsResponse>(coroutines) {
            override suspend fun saveCallResult(item: TeamsResponse) {
                teamDao.saveTeams(item.teams)
            }

            override fun createCall(): LiveData<BaseResponse<TeamsResponse>> {
                return footballService.getTeam(teamId)
            }

            override fun shouldFetch(data: Team?): Boolean = data == null

            override suspend fun loadFromDatabase(): LiveData<Team> = teamDao.getTeam(teamId)
        }.asLiveData()

}
