package vn.sunasterisk.realfootball.data.repository

import androidx.lifecycle.LiveData
import com.rifqimfahmi.foorballapps.data.source.remote.json.SchedulesResponse
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.base.ContextProviders
import vn.sunasterisk.realfootball.base.NetworkBoundResource
import vn.sunasterisk.realfootball.constant.Constant
import vn.sunasterisk.realfootball.data.local.MatchDao
import vn.sunasterisk.realfootball.data.model.Match
import vn.sunasterisk.realfootball.di.FootballService

class MatchRepository(
    val coroutines: ContextProviders,
    private val footballService: FootballService,
    private val matchDao: MatchDao
) {
    fun getMatch(leagueId: String, type: String): LiveData<BaseResponse<List<Match>>> =
        object : NetworkBoundResource<List<Match>, SchedulesResponse>(coroutines) {
            override suspend fun saveCallResult(item: SchedulesResponse) {
                val matches = item.events
                matches?.let { matchesData ->
                    matchesData.forEach { match ->
                        match?.let {
                            match.matchType = type
                        }
                    }
                    matchDao.apply {
                        deleteMatches(leagueId, type)
                        saveMatches(matches)
                    }
                }
            }

            override fun createCall(): LiveData<BaseResponse<SchedulesResponse>> {
                return if (type == Constant.TYPE_NEXT_MATCH) {
                    footballService.getNextMatch(leagueId)
                } else {
                    footballService.getLastMatch(leagueId)
                }
            }

            override fun shouldFetch(data: List<Match>?) = true

            override suspend fun loadFromDatabase() = matchDao.getMatches(leagueId, type)
        }.asLiveData()


    fun getEventDetail(matchId: String): LiveData<BaseResponse<Match>> =
        object : NetworkBoundResource<Match, SchedulesResponse>(coroutines) {
            override suspend fun saveCallResult(item: SchedulesResponse) {
                item.events?.let {
                    matchDao.saveMatches(it)
                }
            }

            override fun createCall() = footballService.getMatchDetail(matchId)

            override fun shouldFetch(data: Match?) = data == null

            override suspend fun loadFromDatabase() = matchDao.getMatchDetail(matchId)

        }.asLiveData()
}
